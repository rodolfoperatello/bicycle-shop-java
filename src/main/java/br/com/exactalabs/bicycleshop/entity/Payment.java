package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O valor do pagamento não pode ser nulo")
    @PositiveOrZero(message = "O valor do pagamento deve ser maior ou igual a 0")
    @Column(name = "payment_value")
    private BigDecimal paymentValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(BigDecimal paymentValue) {
        this.paymentValue = paymentValue;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id=" + id +
                ", paymentValue=" + paymentValue +
                '}';
    }
}
