package br.com.exactalabs.bicycleshop.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode ser vazio")
    private String name;
    @Column(name = "last_name")
    @NotBlank(message = "O sobrenome não pode ser vazio")
    private String lastName;
    @CPF(message = "O CPF deve ser válido")
    @NotBlank(message = "O CPF não pode ser vazio")
    private String cpf;
    @Email(message = "O email deve ser válido")
    @NotBlank(message = "O email não pode ser vazio")
    private String email;
    @NotBlank(message = "O telefone principal não pode ser vazio")
    @Column(name = "main_phone")
    private String mainPhone;
    @Column(name = "secondary_phone")
    private String secondaryPhone;
    @NotNull(message = "A data de nascimento não pode ser nulo")
    private LocalDate birthday;
    @NotEmpty(message = "A lista de endereços não pode estar vazia")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<Address> addressList;

    public Customer(){

    }

    private Customer(String name, String lastName, String cpf, String mainPhone, String secondaryPhone, LocalDate birthday, String email, List<Address> addressList) {
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.mainPhone = mainPhone;
        this.secondaryPhone = secondaryPhone;
        this.birthday = birthday;
        this.email = email;
        this.addressList = addressList;
    }

    public static class CustomerBuilder {

        private String name;
        private String lastName;
        private String cpf;
        private String email;
        private String mainPhone;
        private String secondaryPhone;
        private LocalDate birthday;
        private List<Address> addressList = new ArrayList<>();


        public CustomerBuilder name(String name){
            this.name = name;
            return this;
        }

        public CustomerBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public CustomerBuilder cpf(String cpf){
            this.cpf = cpf;
            return this;
        }

        public CustomerBuilder email(String email){
            this.email = email;
            return this;
        }

        public CustomerBuilder mainPhone(String mainPhone){
            this.mainPhone = mainPhone;
            return this;
        }

        public CustomerBuilder secondaryPhone(String secondaryPhone){
            this.secondaryPhone = secondaryPhone;
            return this;
        }

        public CustomerBuilder birthday(LocalDate birthday){
            this.birthday = birthday;
            return this;
        }

        public CustomerBuilder addAddress(Address adress){
            this.addressList.add(adress);
            return this;
        }

        public Customer createCustomer(){
            return new Customer(name, lastName, cpf, mainPhone, secondaryPhone, birthday, email, addressList);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }
    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public void addAdress(Address address) {
        if (address != null){
            this.addressList.add(address);
        }
    }

    public void removeAdress(Address address) {
        this.addressList.remove(address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", mainPhone='" + mainPhone + '\'' +
                ", secondaryPhone='" + secondaryPhone + '\'' +
                ", birthday=" + birthday +
                ", addressList=" + addressList +
                '}';
    }
}
