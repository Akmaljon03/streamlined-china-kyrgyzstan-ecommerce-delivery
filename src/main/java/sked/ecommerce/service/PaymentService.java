package sked.ecommerce.service;

import sked.ecommerce.entity.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sked.ecommerce.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Create a new payment
    public void createPayment(Payment newPayment) {
        paymentRepository.save(newPayment);
    }
}
