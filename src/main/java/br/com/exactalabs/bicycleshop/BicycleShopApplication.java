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
import java.time.YearMonth;


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

            var addressToSave = new Address.AddressBuilder()
                    .street("Camargo Schutz")
                    .district("Vila Prado")
                    .city("São Carlos")
                    .state("São Paulo")
                    .zipCode("13999420")
                    .number("1200")
                    .complement("Próximo ao hospital")
                    .createAddress();


            var customerToSave = new Customer.CustomerBuilder()
                    .name("Fernando")
                    .lastName("Oliveira")
                    .cpf("94143295016")
                    .mainPhone("16988888888")
                    .secondaryPhone("")
                    .birthday(LocalDate.of(1990,1,1))
                    .email("oliveira@email.com")
                    .addAddress(addressToSave)
                    .createCustomer();

            //customerService.saveCustomer(customerToSave);

            var customer = customerService.findCustomerById(customerToSave.getId());

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

            var mountainBikeToSave = new Product("Mountain Bike Everest", bikeCategory, BigDecimal.valueOf(2250.00));
            var speedBikeToSave = new Product("Speed Bike Emigrantes", bikeCategory, BigDecimal.valueOf(5640.00));
            var chinatownBikeToSave = new Product("Chinatown Classic Bike", bikeCategory, BigDecimal.valueOf(799.90));
            var luvasTysonToSave = new Product("Luvas Tyson", glovesCategory, BigDecimal.valueOf(189.90));
            var squeezerSquirtleToSave = new Product("Squeezer Squirtle", squeezerCategory, BigDecimal.valueOf(30.00));
            var capaceteDragonBornToSave = new Product("Capacete Dragon Born", helmetCategory, BigDecimal.valueOf(650.90));

//            productService.saveProduct(mountainBikeToSave);
//            productService.saveProduct(speedBikeToSave);
//            productService.saveProduct(chinatownBikeToSave);
//            productService.saveProduct(luvasTysonToSave);
//            productService.saveProduct(squeezerSquirtleToSave);
//            productService.saveProduct(capaceteDragonBornToSave);

            var mountainBike = productService.findProductById(379L);
            var speedBike = productService.findProductById(380L);
            var chinatownBike = productService.findProductById(381L);
            var glovesTyson = productService.findProductById(382L);
            var squeezerSquirtle = productService.findProductById(383L);
            var capaceteDragonBorn = productService.findProductById(384L);


            var creditCardCustomer1 = new CreditCard("4916396776205913", "Giovanna Gonçalves", "231", YearMonth.of(2030, 12));
            var creditCardCustomer2 = new CreditCard("4539069995203095", "Luiza Cavalcanti", "771", YearMonth.of(2026, 6));
            var bankSlip1 = new BankSlip("11111111111111111");
            var bankSlip2 = new BankSlip("99999999999999999");

            var item1 = new OrderItem(mountainBike, 2);
            var item2 = new OrderItem(glovesTyson, 2);
            var item3 = new OrderItem(capaceteDragonBorn, 2);

            var order = new Order(customer, creditCardCustomer1);
            order.addOrderedItem(item1);
            order.addOrderedItem(item2);
            order.addOrderedItem(item3);

            //orderService.saveOrder(order);

            System.out.println(orderService.findOrderById(190L));


            System.out.println("Spring bootado");

        };
    }
}