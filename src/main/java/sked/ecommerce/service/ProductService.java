package sked.ecommerce.service;

import sked.ecommerce.entity.product.Product;
import sked.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Create a new product
    public void createProduct(Product newProduct) {
        productRepository.save(newProduct);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Product getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }

    // Update product
    public boolean updateProduct(Long productId, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            updatedProduct.setId(productId); // Ensure the updated product has the correct ID
            productRepository.save(updatedProduct);
            return true;
        } else {
            return false;
        }
    }

    // Delete product
    public boolean deleteProduct(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            productRepository.deleteById(productId);
            return true;
        } else {
            return false;
        }
    }
}
