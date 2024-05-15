package sked.ecommerce.entity.adress;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Category {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    public Category() {}

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setParentCategory(Category parentCategory) {this.parentCategory = parentCategory;}
    public Category getParentCategory() {return parentCategory;}

    public Category(String name, Category parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
    }
}
