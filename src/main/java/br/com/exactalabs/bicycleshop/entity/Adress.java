package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "A rua não pode ser nulo")
    @NotBlank(message = "A rua não pode ser vazio")
    private String street;
    @NotNull(message = "O bairro não pode ser nulo")
    @NotBlank(message = "O bairro não pode ser vazio")
    private String district;
    @NotNull(message = "A cidade não pode ser nulo")
    @NotBlank(message = "A cidade não pode ser vazio")
    private String city;
    @NotNull(message = "O estado não pode ser nulo")
    @NotBlank(message = "O estado não pode ser vazio")
    private String state;
    @NotNull(message = "O CEP não pode ser nulo")
    @NotBlank(message = "O CEP não pode ser vazio")
    private String zipcode;
    @NotNull(message = "O número não pode ser nulo")
    @NotBlank(message = "O número não pode ser vazio")
    @Column(name = "adressnumber")
    private String number;


    public Adress(){

    }

    public Adress(String street, String district, String city, String state, String zipcode, String number) {
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

