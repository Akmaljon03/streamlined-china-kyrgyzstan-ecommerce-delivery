package sked.ecommerce.service;

import sked.ecommerce.entity.order.Order;
import sked.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Create a new order
    public void createOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    public Order getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.orElse(null);
    }

    // Update order
    public boolean updateOrder(Long orderId, Order updatedOrder) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            updatedOrder.setId(orderId); // Ensure the updated order has the correct ID
            orderRepository.save(updatedOrder);
            return true;
        } else {
            return false;
        }
    }

    // Delete order
    public boolean deleteOrder(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            orderRepository.deleteById(orderId);
            return true;
        } else {
            return false;
        }
    }
}
