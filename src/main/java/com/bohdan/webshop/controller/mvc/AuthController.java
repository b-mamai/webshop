package com.bohdan.webshop.controller.mvc;

import com.bohdan.webshop.entity.User;
import com.bohdan.webshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registration() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(User user, Map<String, Object> model, RedirectAttributes redirectAttributes,
                               HttpServletRequest request) {
        if (!userService.createUser(user)) {
            model.put("message", "User already exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}
