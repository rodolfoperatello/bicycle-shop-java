package br.com.exactalabs.bicycleshop.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "ordered")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ordered_id")
    @NotEmpty(message = "A lista de itens do pedido não pode ser estar vazia")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<OrderedItem> orderedItems = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "customer_id")
    @NotNull(message = "O cliente não pode ser nulo")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    @NotNull(message = "O método de pagamento não pode ser nulo")
    private Payment payment;
    @FutureOrPresent(message = "A data da ordem de compra não pode estar no passado")
    @Column(name = "order_date")
    private LocalDate orderDate;
    @PositiveOrZero(message = "O total da ordem deve ser maior ou igual a zero")
    @Column(name = "order_total")
    private BigDecimal orderTotal;
    @Positive(message = "A quantidade de produtos deve ser maior que zero")

    public Order() {
        this.orderDate = LocalDate.now();
        this.orderTotal = BigDecimal.valueOf(0);
    }

    public Order(Customer customer, Payment payment) {
        this();
        this.customer = customer;
        this.payment = payment;
    }

    private void updateOrderTotal(OrderedItem orderedItem){
        var productPrice = orderedItem.getProduct().getPrice();
        var productQuantity = orderedItem.getQuantitaty();
        this.orderTotal = this.orderTotal.add(productPrice.multiply(BigDecimal.valueOf(productQuantity)));
        this.payment.setPaymentValue(this.getOrderTotal());
    }

    public void addOrderedItem(OrderedItem orderedItem){
        if (orderedItem != null) {
            this.orderedItems.add(orderedItem);
            updateOrderTotal(orderedItem);
        }
    }

    public void removeOrderedItem(OrderedItem orderedItem){
        this.orderedItems.remove(orderedItem);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<OrderedItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Collection<OrderedItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderedItems=" + orderedItems +
                ", customer=" + customer +
                ", payment=" + payment +
                ", orderDate=" + orderDate +
                ", orderTotal=" + orderTotal +
                '}';
    }
}

