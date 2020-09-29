package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderedItems")
public class OrderedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantitaty;

    public OrderedItem(){
    }

    public OrderedItem(Product product, int quantitaty){
        this.product = product;
        this.quantitaty = quantitaty;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantitaty() {
        return quantitaty;
    }

    public void setQuantitaty(int quantitaty) {
        this.quantitaty = quantitaty;
    }

    @Override
    public String toString() {
        return "OrderedItems{" +
                "id=" + id +
                ", product=" + product +
                ", quantitaty=" + quantitaty +
                '}';
    }
}


