package sked.ecommerce.controllers;

import io.swagger.annotations.Authorization;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sked.ecommerce.payload.address.AddressRequest;
import sked.ecommerce.payload.user.UserResponse;
import sked.ecommerce.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public UserResponse findUserByEmail(@RequestHeader("Authorization") String token) {
        return userService.findUserByEmail(token);
    }

    @PostMapping("/createAddress")
    public void createAddress(@RequestHeader("Authorization") String token, @RequestBody AddressRequest addressRequest) {
        userService.createAddress(token, addressRequest);
    }

    @PutMapping("/updateAddress")
    public void updateAddress(@RequestHeader("Authorization") String token, @RequestBody AddressRequest addressRequest) {
        userService.updateAddress(token, addressRequest);
    }

    @DeleteMapping("/deleteAddress")
    public void deleteAddress(@RequestHeader("Authorization") String token) {
        userService.deleteAddress(token);
    }

}
