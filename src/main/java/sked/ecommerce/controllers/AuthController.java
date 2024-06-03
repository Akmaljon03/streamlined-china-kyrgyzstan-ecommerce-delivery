package sked.ecommerce.controllers;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sked.ecommerce.payload.auth.AuthLoginRequest;
import sked.ecommerce.payload.auth.AuthRegisterRequest;
import sked.ecommerce.payload.auth.AuthResponse;
import sked.ecommerce.service.AuthService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody AuthRegisterRequest authRegisterRequest) {
        return authService.register(authRegisterRequest);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthLoginRequest authLoginRequest) {
        return authService.login(authLoginRequest);
    }
}
