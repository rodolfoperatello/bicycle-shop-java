package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.entity.ProductCategory;
import br.com.exactalabs.bicycleshop.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class BicycleAppProduct {

    public static void main(String[] args) {
        SpringApplication.run(BicycleAppProduct.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return args -> {

            var productService = appContext.getBean(ProductService.class);

//            var bikeCategory = new ProductCategory("Bike");
//            var glovesCategory = new ProductCategory("Luva");
//            var squeezerCategory = new ProductCategory("Squeezer");
//            var helmetCategory = new ProductCategory("Helmet");

            //var mountainBike = new Product("Mountain Bike Everest", bikeCategory, BigDecimal.valueOf(2250.00));
            var bikeCategory = productService.findCategoryById(223L);
            System.out.println(bikeCategory);
            bikeCategory.addProduct(null);

            System.out.println(productService.findProductById(354L));

//            var mountainBike = new Product("Mountain Bike Everest", bikeCategory, BigDecimal.valueOf(2250.00));
//            var speedBike = new Product("Speed Bike Emigrantes", bikeCategory, BigDecimal.valueOf(5640.00));
//            var chinatownBike = new Product("Chinatown Classic Bike", bikeCategory, BigDecimal.valueOf(799.90));
//            var luvasTyson = new Product("Luvas Tyson", glovesCategory, BigDecimal.valueOf(189.90));
//            var squeezerSquirtle = new Product("Squeezer Squirtle", squeezerCategory, BigDecimal.valueOf(30.00));
//           var capaceteDragonBorn = new Product("Capacete Dragon Born", helmetCategory, BigDecimal.valueOf(650.90));
            //var capaceteDragonBorn = new Product("Capacete Dragon Born", helmetCategory, BigDecimal.valueOf(0));

            //productService.saveProduct(chinatownBike);

//            var helmetCategoryUpdate = productService.findCategoryById(233L);
//            helmetCategoryUpdate.setName("Helmet");
//            productService.updateCategory(helmetCategoryUpdate);

            //System.out.println(productService.saveProduct(capaceteDragonBorn));

//            var capacete = productService.findProductById(353L);
//            capacete.setName("Capacete Dragon Born");
//            productService.updateProduct(capacete);

//            System.out.println("Achando todos os produtos : "+productService.findAllProducts(0).getContent().toString());
//            System.out.println("Achando produtos pelo menor preço: " +productService.findAllProductByPriceAsc(0).getContent().toString());
//            System.out.println("Achando produtos pelo maior preço: " +productService.findAllProductByPriceDesc(0).getContent().toString());
//            System.out.println("Achando produtos pelo nome da categoria: " +productService.findAllProductsByCategory("helmet", 0).getContent().toString());
//            System.out.println("Achando produtos pelo nome: " +productService.findAllProductsByName("%bike%",0).getContent().toString());
//

            //productService.deleteProductById(346L);


//            var outroHelmet = new Product("Novo Capacete", helmetCategory, BigDecimal.valueOf(0));
//            helmetCategory.addProduct(outroHelmet);
//            System.out.println(helmetCategory.getProductList());

            //productService.deleteCategoryById(228L);

//            System.out.println(productService.saveProduct(outroHelmet));




            System.out.println("Spring bootado");

        };
    }
}