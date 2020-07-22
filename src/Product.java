import java.math.BigDecimal;

public class Product {

    private String name;
    private ProductCategory productCategory;
    private BigDecimal price;

    public Product() {

    }

    public Product (String name, ProductCategory productCategory, BigDecimal price) {
        this.name = name;
        this.productCategory = productCategory;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
