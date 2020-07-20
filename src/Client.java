import java.time.LocalDate;

public class Client {

    private String name, lastName, cpf, email, phoneNumber, secondaryPhoneNumber;
    private Adress adress;
    private LocalDate birthday;

    public Client(){

    }

    public Client(String name, String lastName, LocalDate birthday, String cpf, String email, String phoneNumber,
                  String secondaryPhoneNumber, Adress adress) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.cpf = cpf;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSecondaryPhoneNumber() {
        return secondaryPhoneNumber;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
        this.secondaryPhoneNumber = secondaryPhoneNumber;
    }
}
