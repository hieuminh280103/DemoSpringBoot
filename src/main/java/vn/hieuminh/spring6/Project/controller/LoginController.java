package vn.hieuminh.spring6.Project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "login";
    }
    @GetMapping
    public String process(){
        return "public";
    }

    SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
    @GetMapping("/logout")
    public String performLogout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        // .. perform logout
        this.logoutHandler.logout(request, response, authentication);
        return "redirect:/";
    }
}
