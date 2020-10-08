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

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable(value = "id") Long id){
        return this.productService.findProductById(id);
    }

    @GetMapping("/product")
    public List<Product> findAllProducts(@RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){
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

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable(value = "id") Long id){
        this.productService.deleteProductById(id);
    }

}
