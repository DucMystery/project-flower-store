package duc.model.carts;

import duc.model.Flower;

import javax.persistence.*;

@Entity
@Table
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CartItem_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @OneToOne  //many to one
    private Flower flower;

    private int price;
    private int quantity;
    private int total;

    public int getTotal() {
        return total;
    }

    public CartItem setTotal(int total) {
        this.total = total;
        return this;
    }

    public Long getCartItem_id() {
        return CartItem_id;
    }

    public CartItem setCartItem_id(Long cartItem_id) {
        CartItem_id = cartItem_id;
        return this;
    }

    public Cart getCart() {
        return cart;
    }

    public CartItem setCart(Cart cart) {
        this.cart = cart;
        return this;
    }

    public Flower getFlower() {
        return flower;
    }

    public CartItem setFlower(Flower flower) {
        this.flower = flower;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public CartItem setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public CartItem setQuantity(int quantity) {
        this.quantity = quantity;
        this.total =quantity*getFlower().getPrice();
        return this;
    }
}
