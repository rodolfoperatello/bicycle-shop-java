package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}