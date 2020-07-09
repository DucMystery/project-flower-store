package duc.controller;

import duc.model.Flower;
import duc.model.carts.Cart;
import duc.model.carts.CartItem;
import duc.model.login.Account;
import duc.service.CartItemService;
import duc.service.CartService;
import duc.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private HttpSession session;

    @Autowired
    private FlowerService flowerService;

    @GetMapping("/showCart")
    public ModelAndView showCart(@RequestParam("searchCart")Optional<String> sC, @PageableDefault(size = 8)Pageable pageable){
        Object object = session.getAttribute("cart");
        Cart cart = (Cart)object;
        Set<CartItem> list =cart.getCartItemList();
        ModelAndView modelAndView =new ModelAndView("/carts/list");
        modelAndView.addObject("cartItems",list);
        return modelAndView;
    }

    @RequestMapping("/addToCart/{id}")
    public String addToCart(@PathVariable("id")Long id, Model model){
        Object object = session.getAttribute("cart");
        Object o = session.getAttribute("accountId");
        Account account = (Account) o;
        Flower flower = flowerService.findById(id);
        if (object==null){
            Cart cart = new Cart();
            CartItem cartItem = new CartItem();
            cartItem.setFlower(flower);
            cartItem.setQuantity(1);

            Set<CartItem> list = new HashSet<>();
            list.add(cartItem);
            cart.setCartItemList(list);
            cart.setAccount(account);
            session.setAttribute("cart",cart);
            model.addAttribute("cart",cart);
        }else {
            boolean isExistInCart = false;
            Cart cart = (Cart)object;
            Set<CartItem> cartItems = cart.getCartItemList();
            for (CartItem cartItem :cartItems){
                if (cartItem.getFlower().getFlower_id()==flower.getFlower_id()){
                    cartItem.setQuantity(cartItem.getQuantity()+1);
                    cart.setCartItemList(cartItems);
                    session.setAttribute("cart",cart);
                    isExistInCart=true;
                    break;
                }
            }
            if (!isExistInCart){
                CartItem cartItem = new CartItem();
                cartItem.setFlower(flower);
                cartItem.setQuantity(1);
                cartItems.add(cartItem);
                cart.setCartItemList(cartItems);
            }
            session.setAttribute("cart",cart);
        }
        return "redirect:/flowers";
    }

    @RequestMapping(value = "/updateCart",method = RequestMethod.POST)
    public String updateCart(@RequestParam(name = "quantity")int[] quantity,Model model){
        Object object = session.getAttribute("cart");
        Cart cart = (Cart)object;
        Set<CartItem> list = cart.getCartItemList();
        int index = 0;
        for (CartItem item : list) {
            item.setQuantity(quantity[index]);
            index++;
        }
        cart.setCartItemList(list);
        session.setAttribute("cart",cart);
        model.addAttribute("cartItems",cart.getCartItemList());
        return "carts/list";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView saveCart(){
        Object object = session.getAttribute("cart");
        Cart cart = (Cart)object;
        Set<CartItem> list = cart.getCartItemList();
        int sum=0;
        for (CartItem item : list){
            sum += item.getTotal();
        }
        cartService.save(cart);
        ModelAndView modelAndView = new ModelAndView("carts/pay");
        modelAndView.addObject("sum",sum);
        modelAndView.addObject("quantity",list.size());
        return modelAndView;
    }
}
