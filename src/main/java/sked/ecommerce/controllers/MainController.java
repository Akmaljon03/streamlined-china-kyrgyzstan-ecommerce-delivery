package sked.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")

// Controller class for handling the main pages of the applicatio
@Controller
public class MainController {

    // Display the home page
    @GetMapping
    public String home() {
        return "forward:/html/index.html";
    }

    // Display the about page
    @GetMapping("/about")
    public String about() {
        return "redirect:about.html";
    }

    // Display the contact page
    @GetMapping("/change-password")
    public String contact() {
        return "redirect:ChangePasswordProfile.html";
    }

    // Display the login page
    @GetMapping("/signin")
    public String login() {
        return "redirect:sign-in.html";
    }

    // Display the register page
    @GetMapping("/register")
    public String register() {
        return "redirect:registeration.html";
    }

    // Display the products page
    @GetMapping("/products")
    public String products() {
        return "products";
    }

    // Display the product details page
    @GetMapping("/products/{productId}")
    public String productDetails() {
        return "productDetails";
    }

    // Display the cart page
    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    // Display the checkout page
    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

    // Display the order confirmation page
    @GetMapping("/order-confirmation")
    public String orderConfirmation() {
        return "orderConfirmation";
    }

    // Display the profile page
    @GetMapping("/profile")
    public String profile() {
        return "redirect:UserProfile.html";
    }

    // Display the order history page
    @GetMapping("/order-history")
    public String orderHistory() {
        return "orderHistory";
    }

    // Display the address book page
    @GetMapping("/address-book")
    public String addressBook() {
        return "addressBook";
    }

    // Display the payment methods page
    @GetMapping("/payment-methods")
    public String paymentMethods() {
        return "paymentMethods";
    }

    // Display the settings page
    @GetMapping("/settings")
    public String settings() {
        return "settings";
    }

    // Display the admin dashboard page
    @GetMapping("/admin")
    public String adminDashboard() {
        return "redirect:admin.html";
    }

    // Display the admin orders page
    @GetMapping("/admin/orders")
    public String adminOrders() {
        return "adminOrders";
    }

    // Display the admin products page
    @GetMapping("/admin/products")
    public String adminProducts() {
        return "adminProducts";
    }

    // Display the admin customers page

    @GetMapping("/admin/customers")

    public String adminCustomers() {
        return "adminCustomers";
    }

    // Display the admin reports page
    @GetMapping("/admin/reports")
    public String adminReports() {
        return "adminReports";
    }

    // Display the admin settings page
    @GetMapping("/admin/settings")
    public String adminSettings() {
        return "adminSettings";
    }
}