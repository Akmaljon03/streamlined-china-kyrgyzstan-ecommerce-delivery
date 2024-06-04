package sked.ecommerce.payload.address;

import lombok.Data;

@Data
public class AddressRequest {
    private String streetAddress;
    private String city;
    private String country;
    private String postalCode;
}
