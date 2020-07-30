import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public class Order {

    private Product product;
    private Client client;
    private PaymentMethod paymentMethod;
    private LocalDate orderDate;
    private int quantitaty;
    private BigDecimal orderTotal;

    public Order() {
        this.orderDate = LocalDate.now();
    }

    public Order(Product product, int quantitaty, PaymentMethod paymentMethod, Client client) throws OrderException, CreditCardException {
        this();
        setPaymentMethod(paymentMethod);
        setClient(client);
        setProduct(product);
        setQuantitaty(quantitaty);
        setOrderTotal(quantitaty, product);
        updatePaymentMethodValue();
    }

    private void setOrderTotal(int quantitaty, Product product) throws OrderException {
        this.orderTotal = getOrderTotal(quantitaty, product);
        updatePaymentMethodValue();
    }

    private void updatePaymentMethodValue() {
        this.getPaymentMethod().setPaymentValue(getOrderTotal(this.getQuantitaty(), this.getProduct()));
    }

    private void paymentMethodValidation(PaymentMethod paymentMethod) throws CreditCardException {
        if (paymentMethod instanceof CreditCard) {
            YearMonth creditCardValidThru = ((CreditCard) paymentMethod).getValidThru();
            YearMonth convertOrderDate = YearMonth.from(this.getOrderDate());
            if (creditCardValidThru.isBefore(convertOrderDate)) {
                throw new CreditCardException("Cartão de crédito expirado");
            }
            this.paymentMethod = paymentMethod;
        } else {
            this.paymentMethod = paymentMethod;
        }
    }

    public void increaseQuantitaty() throws OrderException {
        this.quantitaty += 1;
        setOrderTotal(quantitaty, this.getProduct());
    }

    public void decreaseQuantitaty() throws OrderException {
        if (this.getQuantitaty() <= 1) {
            throw new OrderException("A quantidade de produtos deve ser maior ou igual a um");
        }
        this.quantitaty -= 1;
        setOrderTotal(quantitaty, this.getProduct());
    }

    public void setQuantitaty(int quantitaty) throws OrderException {
        if (quantitaty <= 0) {
            throw new OrderException("A quantidade de produtos deve ser maior que zero");
        }
        this.quantitaty = quantitaty;
        setOrderTotal(quantitaty, this.getProduct());
    }

    public void setClient(Client client) throws OrderException {
        if (client == null) {
            throw new OrderException("O cliente não pode ser nulo");
        }
        this.client = client;
    }

    public void setOrderDate(LocalDate orderDate) throws OrderException {
        if (orderDate == null) {
            throw new OrderException("A data da ordem não pode ser nula");
        }
        this.orderDate = orderDate;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) throws OrderException, CreditCardException {
        if (paymentMethod == null) {
            throw new OrderException("O método de pagamento não pode ser nulo");
        }
        paymentMethodValidation(paymentMethod);
    }

    public void setProduct(Product product) throws OrderException {
        if (product == null) {
            throw new OrderException("O produto não pode ser nulo");
        }
        this.product = product;
        setOrderTotal(this.getQuantitaty(), product);
    }


    public void setOrderTotal(BigDecimal orderTotal) throws OrderException {
        if (orderTotal == null) {
            throw new OrderException("O valor da ordem não pode ser nulo");
        }
        if (orderTotal.compareTo(new BigDecimal(-0)) == -1) {
            throw new OrderException("O valor da ordem não pode ser menor que zero");
        }
        this.orderTotal = orderTotal;
        this.getPaymentMethod().setPaymentValue(this.getOrderTotal());
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    private BigDecimal getOrderTotal(int quantitaty, Product product) {
        BigDecimal convertQuantitaty = new BigDecimal(quantitaty);
        BigDecimal orderTotal = convertQuantitaty.multiply(product.getPrice());
        return orderTotal;
    }

    public Client getClient() {
        return client;
    }

    public int getQuantitaty() {
        return quantitaty;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

}
