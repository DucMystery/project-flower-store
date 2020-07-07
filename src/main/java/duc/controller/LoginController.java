package duc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView showLoginForm(){
        ModelAndView modelAndView = new ModelAndView(("accounts/login"));
        return modelAndView;
    }

    @GetMapping("/")
    public String getHomePage(){
        return "redirect:/flowers";
    }
}
