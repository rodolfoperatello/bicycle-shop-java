import java.time.LocalDate;

public class Client {

    private String name, lastname, mainPhone, secondaryPhone;
    private LocalDate birthday;
    private Adress adress;

    public Client(){

    }

    public Client(String name, String lastname, String mainPhone, String secondaryPhone, LocalDate birthday, Adress adress) {
        this.name = name;
        this.lastname = lastname;
        this.mainPhone = mainPhone;
        this.secondaryPhone = secondaryPhone;
        this.birthday = birthday;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
