package sked.ecommerce.payload.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthLoginRequest {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
}
