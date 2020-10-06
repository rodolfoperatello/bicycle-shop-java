package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.*;
import br.com.exactalabs.bicycleshop.service.CustomerService;
import br.com.exactalabs.bicycleshop.service.OrderService;
import br.com.exactalabs.bicycleshop.service.ProductCategoryService;
import br.com.exactalabs.bicycleshop.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


import java.math.BigDecimal;
import java.time.LocalDate;


@SpringBootApplication
public class BicycleShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BicycleShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return args -> {

            var customerService = appContext.getBean(CustomerService.class);
            var productService = appContext.getBean(ProductService.class);
            var productCategoryService = appContext.getBean(ProductCategoryService.class);
            var orderService = appContext.getBean(OrderService.class);

            var customerAddress = new Address("Rua", "District", "City", "State", "Zipcode", "Number");
            var newCustomer = new Customer("Nome", "Lastname", "Mainphone",
                    "", LocalDate.of(1991,5,5), customerAddress);


            customerService.saveCustomer(newCustomer);


            var bikeCategoryToSave = new ProductCategory("Bike");
            var glovesCategoryToSave = new ProductCategory("Gloves");
            var squeezerCategoryToSave = new ProductCategory("Squeezer");
            var helmetCategoryToSave = new ProductCategory("Helmet");

//            productCategoryService.saveCategory(bikeCategoryToSave);
//            productCategoryService.saveCategory(glovesCategoryToSave);
//            productCategoryService.saveCategory(squeezerCategoryToSave);
//            productCategoryService.saveCategory(helmetCategoryToSave);

            var bikeCategory = productCategoryService.findCategoryById(255L);
            var glovesCategory = productCategoryService.findCategoryById(256L);
            var squeezerCategory = productCategoryService.findCategoryById(257L);
            var helmetCategory = productCategoryService.findCategoryById(258L);

            var mountainBike = new Product("Mountain Bike Everest", bikeCategory, BigDecimal.valueOf(2250.00));
            var speedBike = new Product("Speed Bike Emigrantes", bikeCategory, BigDecimal.valueOf(5640.00));
            var chinatownBike = new Product("Chinatown Classic Bike", bikeCategory, BigDecimal.valueOf(799.90));
            var luvasTyson = new Product("Luvas Tyson", glovesCategory, BigDecimal.valueOf(189.90));
            var squeezerSquirtle = new Product("Squeezer Squirtle", squeezerCategory, BigDecimal.valueOf(30.00));
            var capaceteDragonBorn = new Product("Capacete Dragon Born", helmetCategory, BigDecimal.valueOf(650.90));

//            productService.saveProduct(mountainBike);
//            productService.saveProduct(speedBike);
//            productService.saveProduct(chinatownBike);
//            productService.saveProduct(luvasTyson);
//            productService.saveProduct(squeezerSquirtle);
//            productService.saveProduct(capaceteDragonBorn);

            var bikeMountain = productService.findProductById(379L);
            var squeezer = productService.findProductById(383L);
            var helmetDragonBorn = productService.findProductById(384L);

            var orderedItens1 = new OrderItem(bikeMountain, 2);
            var orderedItens2 = new OrderItem(squeezer, 2);
            var orderedItens3 = new OrderItem(helmetDragonBorn, 2);
//
//            var creditCardCustomer1 = new CreditCard("4916396776205913", "Giovanna Gonçalves", "231", YearMonth.of(2030, 12));
//            var creditCardCustomer2 = new CreditCard("4539069995203095", "Luiza Cavalcanti", "771", YearMonth.of(2026, 6));
            var bankSlip1 = new BankSlip("11111111111111111");
//            var bankSlip2 = new BankSlip("99999999999999999");
//
            var order = new Order(newCustomer, bankSlip1);
            order.addOrderedItem(orderedItens1);
            order.addOrderedItem(orderedItens2);
            order.addOrderedItem(orderedItens3);
//
            orderService.saveOrder(order);



            System.out.println("Spring bootado");

        };
    }
}