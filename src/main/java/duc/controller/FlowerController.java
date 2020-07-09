package duc.controller;

import duc.model.Category;
import duc.model.Flower;
import duc.service.CategoryService;
import duc.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class FlowerController {
    @Autowired
    Environment env;
    @Autowired
    private FlowerService flowerService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("/categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/flowers")
    public ModelAndView showProducts(@RequestParam("s")Optional<String> s, @PageableDefault(size = 12)Pageable pageable){
        Page<Flower> flowers;
        if (s.isPresent()){
            
            flowers=flowerService.findAllByNameContaining(s.get(),pageable);
        }else {
            flowers=flowerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("flowers",flowers);
        return modelAndView;
    }

    @GetMapping("/create-flower")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("products/create");
        modelAndView.addObject("categories",categoryService.findAll());
        modelAndView.addObject("flower",new Flower());
        return modelAndView;
    }
}
