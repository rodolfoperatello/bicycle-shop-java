package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT t FROM Product t ORDER BY price")
    Collection<Product> findProductByPriceAsc();

    @Query(value = "SELECT t FROM Product t ORDER BY price DESC")
    Collection<Product> findProductByPriceDesc();

    @Query(value = "SELECT t FROM Product t WHERE name like %?1% ORDER BY name ASC")
    Collection<Product> findProductByName(String productName);


    @Query(value = "SELECT t from Product t LEFT JOIN ProductCategory p ON t.productCategory = p.id WHERE p.name LIKE %?1% ORDER BY t.name ASC")
    Collection<Product> findProductByCategory(String categoryName);








}
