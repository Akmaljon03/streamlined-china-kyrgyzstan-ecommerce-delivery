package sked.ecommerce.entity.payment;

import sked.ecommerce.entity.order.Order;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private String transactionId;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    
    public Payment(Order order, Double amount, PaymentMethod paymentMethod, String transactionId, PaymentStatus status) {
        this.order = order;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.status = status;
    }
}
