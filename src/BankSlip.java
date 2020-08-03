import java.time.LocalDate;

public class BankSlip extends PaymentMethod{

    private final String number;
    private final LocalDate creationDate;
    private final LocalDate expirationDate;

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


}
