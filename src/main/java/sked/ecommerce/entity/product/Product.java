package sked.ecommerce.entity.product;


import sked.ecommerce.entity.user.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "product")
public class Product {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String category;
    private Double weight;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    public Product() {}

    public Product(String name, String description, Double price, String category, String imageUrl, Double weight, User seller) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.weight = weight;
        this.seller = seller;
    }

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
}
