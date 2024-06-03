package sked.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")

// Controller class for handling the main pages of the applicatio
@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "forward:/html/index.html"; // Using forward to serve directly
    }

    @GetMapping("/about")
    public String about() {
        return "forward:/html/about.html";
    }

    @GetMapping("/change-password")
    public String contact() {
        return "forward:/html/ChangePasswordProfile.html";
    }

    @GetMapping("/signin")
    public String login() {
        return "forward:/html/sign-in.html";
    }

    @GetMapping("/register")
    public String register() {
        return "forward:/html/registration.html";
    }

    // Follow this pattern for other mappings...
}
