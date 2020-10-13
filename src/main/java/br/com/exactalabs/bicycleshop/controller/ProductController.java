package br.com.exactalabs.bicycleshop.controller;

import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> findAllProducts(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){
        var productList = this.productService.findAllProducts(pageNumber).getContent();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<?> findProductById(@RequestParam Long id){
        var product = this.productService.findProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping(value = "/name")
    public ResponseEntity<?> findProductByName(
            @RequestParam(value = "productName") String name,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){
        var productList = this.productService.findAllProductsByName(name, pageNumber).getContent();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping(value = "/priceAsc")
    public ResponseEntity<?> findProductByPriceAsc(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber) {
        var productList = this.productService.findAllProductByPriceAsc(pageNumber).getContent();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping(value = "/priceDesc")
    public ResponseEntity<?> findProductByPriceDesc(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){
        var productList = this.productService.findAllProductByPriceDesc(pageNumber).getContent();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestParam Long id, @RequestBody Product product){
        this.productService.updateProduct(id, product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        var newProduct = this.productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }
}
