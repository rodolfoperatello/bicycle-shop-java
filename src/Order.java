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

    public Order(){

    }

    public Order(Product product, int quantitaty, PaymentMethod paymentMethod, Client client) throws OrderException, CreditCardException {
        this.orderDate = LocalDate.now();
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

    private void  paymentMethodValidation(PaymentMethod paymentMethod) throws CreditCardException {
        if (paymentMethod instanceof CreditCard) {
            YearMonth creditCardValidThru = ((CreditCard) paymentMethod).getValidThru();
            YearMonth convertOrderDate = YearMonth.from(this.getOrderDate());
            if (creditCardValidThru.isAfter(convertOrderDate)) {
                this.paymentMethod = paymentMethod;
            } else {
                throw new CreditCardException("Cartão de crédito expirado");
            }
        } else {
            this.paymentMethod = paymentMethod;
        }
    }

    public void increaseQuantitaty() throws OrderException {
        this.quantitaty +=1;
        setOrderTotal(quantitaty, this.getProduct());
    }

    public void decreaseQuantitaty() throws OrderException {
        if (this.getQuantitaty() > 1 ) {
            this.quantitaty -=1;
            setOrderTotal(quantitaty, this.getProduct());
        } else {
            throw new OrderException("A quantidade de produtos deve ser maior ou igual a um");
        }
    }

    public void setQuantitaty(int quantitaty) throws OrderException{
        if (quantitaty > 0) {
            this.quantitaty = quantitaty;
            setOrderTotal(quantitaty, this.getProduct());
        } else {
            throw new OrderException("A quantidade de produtos deve ser maior que zero");
        }
    }

    public void setClient(Client client) throws OrderException {
        if (client != null) {
            this.client = client;
        } else {
            throw new OrderException("O cliente não pode ser nulo");
        }
    }

    public void setOrderDate(LocalDate orderDate) throws OrderException {
        if (orderDate != null) {
            this.orderDate = orderDate;
        } else {
            throw new OrderException("A data da ordem não pode ser nula");
        }
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) throws OrderException, CreditCardException {
        if (paymentMethod != null) {
            paymentMethodValidation(paymentMethod);
        } else {
            throw new OrderException("O método de pagamento não pode ser nulo");
        }
    }

    public void setProduct(Product product) throws OrderException {
        if (product != null) {
            this.product = product;
            setOrderTotal(this.getQuantitaty(), product);
        } else {
            throw new OrderException("O produto não pode ser nulo");
        }
    }

    public void setOrderTotal(BigDecimal orderTotal) throws OrderException{
        if (orderTotal != null ){
            if (orderTotal.compareTo(new BigDecimal(-1)) == 1) {
                this.orderTotal = orderTotal;
                this.getPaymentMethod().setPaymentValue(this.getOrderTotal());
            } else {
                throw new OrderException("O valor da ordem não pode ser menor que zero");
            }
        } else {
            throw new OrderException("O valor da ordem não pode ser nulo");
        }
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    private BigDecimal getOrderTotal(int quantitaty, Product product){
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
