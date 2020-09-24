package br.com.exactalabs.bicycleshop.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "customer")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode ser vazio")
    private String name;
    @Column(name = "last_name")
    @NotBlank(message = "O sobrenome não pode ser vazio")
    private String lastName;
    @NotBlank(message = "O telefone principal não pode ser vazio")
    @Column(name = "main_phone")
    private String mainPhone;
    @Column(name = "secondary_phone")
    private String secondaryPhone;
    private LocalDate birthday;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Collection<Adress> adressList = new ArrayList<>();

    public Client(){

    }

    public Client(String name, String lastName, String mainPhone, String secondaryPhone, LocalDate birthday,Adress adress) {
        this.name = name;
        this.lastName = lastName;
        this.mainPhone = mainPhone;
        this.secondaryPhone = secondaryPhone;
        this.birthday = birthday;
        this.addAdress(adress);
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Collection<Adress> getAdressList() {
        return adressList;
    }

    public void setAdressList(Collection<Adress> adressList) {
        this.adressList = adressList;
    }


    public void addAdress(Adress adress) {
        this.adressList.add(adress);
    }

    public void removeAdress(Adress adress) {
        this.adressList.remove(adress);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mainPhone='" + mainPhone + '\'' +
                ", secondaryPhone='" + secondaryPhone + '\'' +
                ", birthday=" + birthday +
                ", adressList=" + adressList +
                '}';
    }
}
