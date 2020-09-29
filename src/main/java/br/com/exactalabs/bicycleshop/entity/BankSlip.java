package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "bankSlip")
public class BankSlip extends Payment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O número não pode ser vazio")
    private String number;
    @NotNull(message = "A data de criação não pode ser nulo")
    @FutureOrPresent(message = "A data de criação não pode estar no passado")
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @NotNull(message = "A data de vencimento não pode ser nulo")
    @FutureOrPresent(message = "A data de vencimento não pode estar no passado")
    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    public BankSlip(){
        this.creationDate = LocalDate.now();
        this.expirationDate = LocalDate.now().plusDays(7);
    }

    public BankSlip(String number) {
        this();
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "BankSlip{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}