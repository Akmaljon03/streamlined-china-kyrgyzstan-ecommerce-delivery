package sked.ecommerce.controllers;

import sked.ecommerce.entity.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sked.ecommerce.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create a new payment
    @PostMapping
    public ResponseEntity<String> createPayment(@RequestBody Payment newPayment) {
        paymentService.createPayment(newPayment);
        return ResponseEntity.status(HttpStatus.CREATED).body("Payment created successfully");
    }
}
