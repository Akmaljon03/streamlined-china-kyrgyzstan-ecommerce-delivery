package sked.ecommerce.entity.order;
import sked.ecommerce.entity.user.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
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

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public User getCustomer() {return customer;}
    public void setCustomer(User customer) {this.customer = customer;}

    public Date getOrderDate() {return orderDate;}
    public void setOrderDate(Date orderDate) {this.orderDate = orderDate;}

    public OrderStatus getStatus() {return status;}
    public void setStatus(OrderStatus status) {this.status = status;}

    public Double getTotal() {return total;}
    public void setTotal(Double total) {this.total = total;}

    public List<OrderItem> getItems() {return items;}
    public void setItems(List<OrderItem> items) {this.items = items;}


}
