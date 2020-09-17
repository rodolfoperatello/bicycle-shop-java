package br.com.exactalabs.bicycleshop.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser vazio")
    private String name;
    @NotNull(message = "A categoria não pode ser nulo")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productCategory")
    private ProductCategory productCategory;
    @NotNull(message = "O preço não pode ser nulo")
    private BigDecimal price;

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
