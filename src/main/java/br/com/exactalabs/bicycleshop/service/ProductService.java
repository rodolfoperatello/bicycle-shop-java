package br.com.exactalabs.bicycleshop.service;


import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.repository.ProductCategoryRepository;
import br.com.exactalabs.bicycleshop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;

    public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository){
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    private PageRequest createPageRequest(Integer pageNumber, Integer pageSize){
        var pageRequest = PageRequest.of(pageNumber, pageSize);
        return pageRequest;
    }

    @Transactional
    public Product saveProduct(Product product) {
        this.productCategoryRepository.save(product.getProductCategory());
        return this.productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    public Product updateProduct(Product product){
        return this.productRepository.save(product);
    }

    public Product findProductById(Long id){
        return this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Collection<Product> findAllProducts(){
        return this.productRepository.findAll();
    }

    public Page<Product> findAllProductByName(String name, Integer pageNumber){
        var pageRequest = createPageRequest(pageNumber, 30);
        return this.productRepository.findAllProductByNameLikeOrderByNameAsc(name, pageRequest);
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


//    public Collection<Product> findProductsByName(String name){
//        return this.productRepository.findProductByName(name);
//    }






}
