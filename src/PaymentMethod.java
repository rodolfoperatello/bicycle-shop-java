import java.math.BigDecimal;

public abstract class PaymentMethod {

    private BigDecimal paymentValue;

    public void setPaymentValue(BigDecimal paymentValue) {
        this.paymentValue = paymentValue;
    }

    public BigDecimal getPaymentValue() {
        return paymentValue;
    }

}
