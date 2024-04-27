package sked.ecommerce.service;

import sked.ecommerce.entity.adress.Address;
import sked.ecommerce.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // Create a new address
    public void createAddress(Address newAddress) {
        addressRepository.save(newAddress);
    }

    // Get all addresses
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    // Get address by ID
    public Address getAddressById(Long addressId) {
        Optional<Address> addressOptional = addressRepository.findById(addressId);
        return addressOptional.orElse(null);
    }

    // Update address
    public boolean updateAddress(Long addressId, Address updatedAddress) {
        Optional<Address> addressOptional = addressRepository.findById(addressId);
        if (addressOptional.isPresent()) {
            updatedAddress.setId(addressId); // Ensure the updated address has the correct ID
            addressRepository.save(updatedAddress);
            return true;
        } else {
            return false;
        }
    }

    // Delete address
    public boolean deleteAddress(Long addressId) {
        Optional<Address> addressOptional = addressRepository.findById(addressId);
        if (addressOptional.isPresent()) {
            addressRepository.deleteById(addressId);
            return true;
        } else {
            return false;
        }
    }
}
