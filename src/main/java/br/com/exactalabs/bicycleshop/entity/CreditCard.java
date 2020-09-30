package br.com.exactalabs.bicycleshop.entity;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Table(name = "credit_card")
@PrimaryKeyJoinColumn(name = "payment_id")
public class CreditCard extends Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O número não pode ser vazio")
    @CreditCardNumber(message = "Número inválido para cartão de crédito")
    private String number;
    @NotBlank(message = "O nome não pode ser vazio")
    private String name;
    @NotBlank(message = "O CVV não pode ser vazio")
    @Length(min = 3, max = 3, message = "O CVV deve possuir 3 dígitos")
    private String cvv;
    @FutureOrPresent(message = "A data de validade não pode ser no passado")
    @Column(name = "valid_thru")
    private LocalDate validThru;

    public CreditCard(){
    }

    public CreditCard(String number, String name, String cvv, YearMonth validThru) {
        this.number = number;
        this.name = name;
        this.cvv = cvv;
        setValidThru(validThru);
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getCvv(){
        return cvv;
    }

    public YearMonth getValidThru() {
        YearMonth dateInValidThru = YearMonth.of(this.getValidThru().getYear(), this.validThru.getMonth());
        return dateInValidThru;
    }

    public void setValidThru(YearMonth validThru) {
        this.validThru = LocalDate.of(validThru.getYear(), validThru.getMonth(), 1);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", cvv='" + cvv + '\'' +
                ", validThru=" + validThru +
                '}';
    }
}


