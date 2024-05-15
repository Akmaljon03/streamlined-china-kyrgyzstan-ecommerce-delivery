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

    public void setUser(User user) {this.user = user;}
    public User getUser() {return user;}

    public void setStreetAddress(String streetAddress) {this.streetAddress = streetAddress;}
    public String getStreetAddress() {return streetAddress;}

    public void setCity(String city) {this.city = city;}
    public String getCity() {return city;}

    public void setCountry(String country) {this.country = country;}
    public String getCountry() {return country;}

    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}
    public String getPostalCode() {return postalCode;}

    public Address() { }
    public Address(User user, String streetAddress, String city, String country, String postalCode) {
        this.user = user;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

}
