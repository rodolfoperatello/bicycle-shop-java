package br.com.exactalabs.bicycleshop.service;


import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.entity.ProductCategory;
import br.com.exactalabs.bicycleshop.repository.ProductCategoryRepository;
import br.com.exactalabs.bicycleshop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    private ProductRepository productRepository;


    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    private PageRequest createPageRequest(Integer pageNumber, Integer pageSize){
        var pageRequest = PageRequest.of(pageNumber, pageSize);
        return pageRequest;
    }

    public Product saveProduct(Product product){
        return this.productRepository.save(product);
    }


    public Product findProductById(Long id){
        return this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    public Product updateProduct(Product product){
        return this.productRepository.save(product);
    }

    public Page<Product> findAllProducts(Integer pageNumber){
        var pageRequest = PageRequest.of(pageNumber, 30, Sort.by("name").ascending());
        return this.productRepository.findAll(pageRequest);
    }

    public Page<Product> findAllProductsByName(String name, Integer pageNumber){
        String nameSearch = "%" + name + "%";
        var pageRequest = createPageRequest(pageNumber, 30);
        return this.productRepository.findAllProductByNameLikeOrderByNameAsc(nameSearch, pageRequest);
    }

    public Page<Product> findAllProductsByCategory(String name, Integer pageNumber) {
        var pageRequest = createPageRequest(pageNumber, 30);
        return this.productRepository.findAllProductByProductCategoryNameOrderByNameAsc(name, pageRequest);
    }

    public Page<Product> findAllProductByPriceAsc(Integer pageNumber) {
        var pageRequest = createPageRequest(pageNumber, 30);
        return this.productRepository.findAllProductByOrderByPriceAsc(pageRequest);
    }

    public Page<Product> findAllProductByPriceDesc(Integer pageNumber) {
        var pageRequest = createPageRequest(pageNumber, 30);
        return this.productRepository.findAllProductByOrderByPriceDesc(pageRequest);
    }



}