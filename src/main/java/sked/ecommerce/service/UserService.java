package sked.ecommerce.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sked.ecommerce.entity.adress.Address;
import sked.ecommerce.entity.user.User;
import sked.ecommerce.exception.CustomException;
import sked.ecommerce.payload.address.AddressRequest;
import sked.ecommerce.payload.user.UserResponse;
import sked.ecommerce.repository.AddressRepository;
import sked.ecommerce.repository.UserRepository;
import sked.ecommerce.security.JwtService;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final JwtService jwtService;

    public UserResponse findUserByEmail(String token) {
        User user = findUser(token);
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setNumber(user.getNumber());
        if(user.getAddress() == null) {
            userResponse.setAddress(null);
        } else {
            Address address = user.getAddress();
            userResponse.setAddress(address.getStreetAddress() + ", " + address.getCity() + ", " + address.getCountry()); // TODO: Should we add the postalCode???
        }
        return userResponse;
    }

    public void createAddress(String token, AddressRequest addressRequest) {
        User user = findUser(token);
        Address address = new Address();
        user.setAddress(generateAddress(address, addressRequest));
        addressRepository.save(address);
        userRepository.save(user);
    }

    public void updateAddress(String token, AddressRequest addressRequest) {
        User user = findUser(token);
        if(user.getAddress() == null) {
            throw new CustomException("Address is not indicated", HttpStatus.BAD_GATEWAY);
        }
        Address address = user.getAddress();
        user.setAddress(generateAddress(address, addressRequest));
        addressRepository.save(address);
        userRepository.save(user);
    }

    public void deleteAddress(String token) {
        User user = findUser(token);
        user.setAddress(null);
    }

    private Address generateAddress(Address address, AddressRequest addressRequest) {
        address.setStreetAddress(addressRequest.getStreetAddress());
        address.setCity(addressRequest.getCity());
        address.setCountry(addressRequest.getCountry());
        address.setPostalCode(addressRequest.getPostalCode());
        return address;
    }

    private User findUser(String token) {
        if(!token.startsWith("Bearer ")) {
            throw new CustomException("Token should be Bearer", HttpStatus.BAD_REQUEST);
        }
        String email = jwtService.getUserEmailFromToken(token.substring(7));
        return userRepository.findUserByEmail(email).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));
    }
}
