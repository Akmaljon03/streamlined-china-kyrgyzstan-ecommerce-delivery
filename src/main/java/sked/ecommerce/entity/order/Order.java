package sked.ecommerce.entity.order;
import lombok.Data;
import lombok.Getter;
import sked.ecommerce.entity.user.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "order_tb")
public class Order {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Double total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Order() {}

    public Order(User customer, Date orderDate, OrderStatus status, Double total, List<OrderItem> items) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
        this.total = total;
        this.items = items;
    }
}
