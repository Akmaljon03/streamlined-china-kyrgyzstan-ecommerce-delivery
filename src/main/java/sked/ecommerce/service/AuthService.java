package sked.ecommerce.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sked.ecommerce.entity.user.ERole;
import sked.ecommerce.entity.user.Role;
import sked.ecommerce.entity.user.User;
import sked.ecommerce.exception.CustomException;
import sked.ecommerce.payload.auth.AuthLoginRequest;
import sked.ecommerce.payload.auth.AuthRegisterRequest;
import sked.ecommerce.payload.auth.AuthResponse;
import sked.ecommerce.repository.UserRepository;
import sked.ecommerce.security.JwtService;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(AuthRegisterRequest registerRequest) {
        if(!registerRequest.getPassword().trim().equals(registerRequest.getConfirmPassword().trim())) {
            throw new CustomException("Password is not same!", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.findUserByEmail(registerRequest.getEmail()).isPresent()) {
            throw new CustomException("User with this email is already registered!", HttpStatus.FOUND);
        }

        User user = new User();
        user.setFullName(registerRequest.getFullName());
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setNumber(registerRequest.getNumber());
        user.setPassword(encoder.encode(registerRequest.getPassword()));
        user.setGender(registerRequest.getGender());
        if(registerRequest.getRole().equals(String.valueOf(ERole.ROLE_ADMIN))) {
            user.setRole(ERole.ROLE_ADMIN);
        } else if (registerRequest.getRole().equals(String.valueOf(ERole.ROLE_MODERATOR))) {
            user.setRole(ERole.ROLE_MODERATOR);
        } else {
            user.setRole(ERole.ROLE_USER);
        }
        userRepository.save(user);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtService.generateToken(user));
        return authResponse;
    }

    public AuthResponse login(AuthLoginRequest authLoginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authLoginRequest.getEmail(),
                        authLoginRequest.getPassword()
                )
        );
        User user = userRepository.findUserByEmail(authLoginRequest.getEmail()).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtService.generateToken(user));
        return authResponse;
    }
}
