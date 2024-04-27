package sked.ecommerce.entity.adress;
import sked.ecommerce.entity.user.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Address {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String streetAddress;
    private String city;
    private String country;
    private String postalCode;

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
}
