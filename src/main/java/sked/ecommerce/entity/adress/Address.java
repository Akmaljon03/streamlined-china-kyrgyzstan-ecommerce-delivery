package sked.ecommerce.entity.adress;
import lombok.Data;
import sked.ecommerce.entity.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@Table(name = "address_tb")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "address")
    private List<User> user;
    private String streetAddress;
    private String city;
    private String country;
    private String postalCode;
}
