package sked.ecommerce.entity.order;

import sked.ecommerce.entity.product.Product;
import jakarta.persistence.*;


@Entity
@Table(name = "OrderItem")
    public class OrderItem {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product;
        @ManyToOne
        @JoinColumn(name = "order_id")
        private Order order;
        private Integer quantity;
    }


