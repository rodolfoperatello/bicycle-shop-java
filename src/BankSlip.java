import java.time.LocalDate;

public class BankSlip extends PaymentMethod{

    private String number;
    private LocalDate creationDate;
    private LocalDate expirationDate;

    public BankSlip(String number) {
        this.number = number;
        this.creationDate = LocalDate.now();
        this.expirationDate = getCreationDate().plusDays(7);
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}

