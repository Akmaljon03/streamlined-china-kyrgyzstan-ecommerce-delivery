package sked.ecommerce.controllers;

import sked.ecommerce.entity.adress.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sked.ecommerce.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // Create a new address
    @PostMapping
    public ResponseEntity<String> createAddress(@RequestBody Address newAddress) {
        addressService.createAddress(newAddress);
        return ResponseEntity.status(HttpStatus.CREATED).body("Address created successfully");
    }

    // Get all addresses
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    // Get address by ID
    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long addressId) {
        Address address = addressService.getAddressById(addressId);
        if (address != null) {
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update address
    @PutMapping("/{addressId}")
    public ResponseEntity<String> updateAddress(@PathVariable Long addressId, @RequestBody Address updatedAddress) {
        if (addressService.updateAddress(addressId, updatedAddress)) {
            return ResponseEntity.ok("Address updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete address
    @DeleteMapping("/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId) {
        if (addressService.deleteAddress(addressId)) {
            return ResponseEntity.ok("Address deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
