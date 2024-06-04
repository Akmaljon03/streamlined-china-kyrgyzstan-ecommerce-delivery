package sked.ecommerce.payload.user;

import lombok.Data;

@Data
public class UserResponse {
    private String username;
    private String email;
    private String number;
    private String address;
    // TODO: Here should be the profile picture of user
}
