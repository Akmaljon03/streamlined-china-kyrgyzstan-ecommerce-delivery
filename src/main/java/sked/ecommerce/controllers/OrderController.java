package sked.ecommerce.controllers;

import sked.ecommerce.entity.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sked.ecommerce.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Create a new order
    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order newOrder) {
        orderService.createOrder(newOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order created successfully");
    }

    // Get all orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // Get order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update order
    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable Long orderId, @RequestBody Order updatedOrder) {
        if (orderService.updateOrder(orderId, updatedOrder)) {
            return ResponseEntity.ok("Order updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete order
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        if (orderService.deleteOrder(orderId)) {
            return ResponseEntity.ok("Order deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
