package br.com.exactalabs.bicycleshop.entity;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode estar vazio")
    private String name;
    @NotNull(message = "A categoria não pode estar vazia")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productCategory_id")
    private ProductCategory productCategory;
    @NotNull(message = "O valor não pode ser nulo")
    @PositiveOrZero(message = "O valor deve ser maior ou igual a zero")
    private BigDecimal price;

    public Product(){

    }

    public Product(String name, ProductCategory productCategory, BigDecimal price) {
        this.name = name;
        this.productCategory = productCategory;
        this.productCategory.addProduct(this);
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productCategory=" + productCategory +
                ", price=" + price +
                '}';
    }
}