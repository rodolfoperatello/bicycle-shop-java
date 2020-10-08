package br.com.exactalabs.bicycleshop.controller;

import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/name")
    public List<Product> findProductByName(
            @RequestParam(value = "productName") String name,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){
        return this.productService.findAllProductsByName(name, pageNumber).getContent();
    }

    @GetMapping("/product/priceAsc")
    public List<Product> findProductByPriceAsc(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber) {
        return this.productService.findAllProductByPriceAsc(pageNumber).getContent();
    }

    @GetMapping("/product/priceDesc")
    public List<Product> findProductByPriceDesc(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){
        return this.productService.findAllProductByPriceDesc(pageNumber).getContent();
    }

    @GetMapping("/product/id")
    public Product findProductById(@RequestParam(value = "id") Long id){
        return this.productService.findProductById(id);
    }

    @GetMapping("/product")
    public List<Product> findAllProducts(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){
        return this.productService.findAllProducts(pageNumber).getContent();
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return this.productService.saveProduct(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return this.productService.updateProduct(product);
    }

    @DeleteMapping("/product/id")
    public void deleteProductById(@RequestParam(value = "id") Long id){
        this.productService.deleteProductById(id);
    }

}
