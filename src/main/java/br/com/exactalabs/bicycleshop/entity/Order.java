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
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @NotEmpty(message = "A lista de itens do pedido não pode ser estar vazia")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<OrderItem> orderItems = new ArrayList<>();
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

    private void updateOrderTotal(OrderItem orderItem){
        var productPrice = orderItem.getProduct().getPrice();
        var productQuantity = orderItem.getQuantitaty();
        this.orderTotal = this.orderTotal.add(productPrice.multiply(BigDecimal.valueOf(productQuantity)));
        this.payment.setPaymentValue(this.getOrderTotal());
    }

    public void addOrderedItem(OrderItem orderItem){
        if (orderItem != null) {
            this.orderItems.add(orderItem);
            updateOrderTotal(orderItem);
        }
    }

    public void removeOrderedItem(OrderItem orderItem){
        this.orderItems.remove(orderItem);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<OrderItem> getOrderedItems() {
        return orderItems;
    }

    public void setOrderedItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
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
                ", orderedItems=" + orderItems +
                ", customer=" + customer +
                ", payment=" + payment +
                ", orderDate=" + orderDate +
                ", orderTotal=" + orderTotal +
                '}';
    }
}

