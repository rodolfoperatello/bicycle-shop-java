package br.com.exactalabs.bicycleshop.service;

import br.com.exactalabs.bicycleshop.entity.ProductCategory;
import br.com.exactalabs.bicycleshop.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public void saveCategory(ProductCategory productCategory){
        this.productCategoryRepository.save(productCategory);
    }

    public void updateCategory(ProductCategory productCategory) {
        this.productCategoryRepository.save(productCategory);
    }

    public ProductCategory findCategoryById(Long id){
        return this.productCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public void deleteCategoryById(Long id) {
        this.productCategoryRepository.deleteById(id);
    }


}
