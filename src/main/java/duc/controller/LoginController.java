package duc.controller;

import duc.model.login.Account;
import duc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession session;

    @GetMapping("/login")
    public ModelAndView showLoginForm(){
        ModelAndView modelAndView = new ModelAndView(("accounts/login"));
        return modelAndView;
    }

    @GetMapping("/")
    public String getHomePage(Principal principal){
        String username = principal.getName();
        Account currentAccount = accountService.findAccountByUsername(username);
        session.setAttribute("account", currentAccount);
        return "redirect:/flowers";
    }
}
