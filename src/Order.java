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

    public Order(Product product, int quantitaty, PaymentMethod paymentMethod, Client client, LocalDate orderDate) throws OrderException {
        setProduct(product);
        setQuantitaty(quantitaty);
        setPaymentMethod(paymentMethod);
        setClient(client);
        setOrderDate(orderDate);
        setOrdemTotal(quantitaty, product);
    }
    //corrigir as entradas
    private void  paymentMethodValidation(PaymentMethod paymentMethod) throws CreditCardExcepton, OrderException {
        if (paymentMethod instanceof CreditCard) {
            YearMonth creditCardValidThru = ((CreditCard) paymentMethod).getValidThru();
            YearMonth convertOrderDate = YearMonth.from(this.getOrderDate());
            if (creditCardValidThru.isAfter(convertOrderDate)) {
                this.paymentMethod = paymentMethod;
                this.paymentMethod.setPaymentValue(getOrderTotal(this.quantitaty, this.product));
            } else {
                throw new CreditCardException("Cartão de crédito expirado");
            }
        } else {
            this.paymentMethod = paymentMethod;
            this.paymentMethod.setPaymentValue(getOrderTotal(this.quantitaty, this.product));
        }
    }

    public void increaseQuantitaty() throws OrderException {
        this.quantitaty +=1;
        this.orderTotal = getOrderTotal(this.quantitaty, this.product);
        if (this.paymentMethod != null) {
            this.paymentMethod.setPaymentValue(getOrderTotal());
        } else {
            throw new OrderException("O método de pagamento é nulo");
        }
    }

    public void decreaseQuantitaty() throws OrderException {
        this.quantitaty -=1;
        this.orderTotal = getOrderTotal(this.quantitaty, this.product);
        if (this.paymentMethod != null) {
           this.paymentMethod.setPaymentValue(getOrderTotal());
        } else {
            throw new OrderException("O método de pagamento é nulo");
        }
    }


    public void setQuantitaty(int quantitaty) throws OrderException{
        if (quantitaty > 0) {
            this.quantitaty = quantitaty;
        } else {
            throw new OrderException("A quantidade de produtos não pode ser menor que zero");
        }
    }

    public void setClient(Client client) throws OrderException {
        if (client != null) {
            this.client = client;
        } else {
            throw new OrderException("O cliente cliente não pode ser nulo");
        }
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) throws OrderException {
        if (paymentMethod != null) {
            paymentMethodValidation(paymentMethod);
        } else {
            throw new OrderException("O método de pagamento não pode ser nulo");
        }
    }

    public void setProduct(Product product) throws OrderException {
        if (product != null) {
            this.product = product;
        } else {
            throw new OrderException("O produto não pode ser nulo");
        }
    }

    private void setOrdemTotal(int quantitaty, Product product) throws OrderException {
        if (quantitaty > 0 && product != null) {
            this.orderTotal = getOrderTotal(quantitaty, product);
        } else {
            throw new OrderException("Para definir o valor total da ordem a quantidade" +
                    "de produto deve ser maior que zero e o produto não pode ser nulo");
        }
    }

    public void setOrderTotal(BigDecimal orderTotal) throws OrderException{
        if (orderTotal.compareTo(new BigDecimal(0)) == 1) {
            this.orderTotal = orderTotal;
            if (this.paymentMethod != null) {
                this.paymentMethod.setPaymentValue(getOrderTotal());
            } else {
                throw new OrderException("O valor da ordem não foi inserido no método" +
                        "de pagamento");
            }
        } else {
            throw new OrderException("O valor da ordem não pode ser menor que zero");
        }
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    private BigDecimal getOrderTotal(int quantitaty, BigDecimal product){
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
