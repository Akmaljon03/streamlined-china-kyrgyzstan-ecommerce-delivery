package sked.ecommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    // Mapping for the root URL
    @GetMapping("/")
    public String home() {
        return "index.html"; // Assuming "index.html" is your home page
    }

    // Mapping for the registration page
    @GetMapping("/")
    public String register() {
        return "register"; // Assuming "register.html" is your registration page


    }
}
