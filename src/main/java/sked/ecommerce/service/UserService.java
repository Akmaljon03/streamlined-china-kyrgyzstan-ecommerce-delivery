package sked.ecommerce.service;

import sked.ecommerce.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sked.ecommerce.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public void createUser(User newUser) {
        userRepository.save(newUser);
    }

    // Authenticate an existing user
    public boolean authenticateUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmailAndPassword(email, password);
        return userOptional.isPresent();
    }

    // Get user by ID
    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }

    // Update user profile
    public boolean updateUser(Long userId, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            updatedUser.setId(userId); // Ensure the updated user has the correct ID
            userRepository.save(updatedUser);
            return true;
        } else {
            return false;
        }
    }

    // Delete user
    public boolean deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            userRepository.deleteById(userId);
            return true;
        } else {
            return false;
        }
    }
}
