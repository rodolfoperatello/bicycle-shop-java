package br.com.exactalabs.bicycleshop.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode estar vazio")
    private String name;
    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    //@NotEmpty(message = "A lista de produtos não pode estar vazia")
    private Collection<Product> productList = new ArrayList<>();

    public ProductCategory (){

    }
    public ProductCategory(String name) {
        this.name = name;
    }

    public void addProduct(Product product){
        if (product != null) {
            this.productList.add(product);
        }
    }

    public void removeProduct(Product product) {
        this.productList.remove(product);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Product> getProductList() {
        return productList;
    }

    public void setProductList(Collection<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}