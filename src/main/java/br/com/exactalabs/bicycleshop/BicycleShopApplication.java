package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.*;
import br.com.exactalabs.bicycleshop.service.CustomerService;
import br.com.exactalabs.bicycleshop.service.OrderService;
import br.com.exactalabs.bicycleshop.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

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
            var orderService = appContext.getBean(OrderService.class);


//            var newAdress = new Address("Rua", "District", "City", "State", "ZipCode", "Number");
//            var newCustomer = new Customer("Rodolfo", "Peratello", "16999999999", "", null, newAdress);

            //customerService.saveCustomer(newCustomer);

            var customer = customerService.findCustomerById(181L);

            var bikeMountain = productService.findProductById(340L);
            var squeezer = productService.findProductById(344L);
            var helmetDragonBorn = productService.findProductById(353L);

            var orderedItens1 = new OrderedItem(bikeMountain, 1);
            var orderedItens2 = new OrderedItem(squeezer, 1);
            var orderedItens3 = new OrderedItem(helmetDragonBorn, 1);


            var creditCardCustomer1 = new CreditCard("4916396776205913", "Giovanna Gonçalves", "231", YearMonth.of(2030, 12));
            var creditCardCustomer2 = new CreditCard("4539069995203095", "Luiza Cavalcanti", "771", YearMonth.of(2026, 6));
            var bankSlip1 = new BankSlip("11111111111111111");
            var bankSlip2 = new BankSlip("99999999999999999");


            var order = new Order(customer, creditCardCustomer2);
            order.addOrderedItem(orderedItens1);
            order.addOrderedItem(orderedItens2);
            order.addOrderedItem(orderedItens3);


            //orderService.saveOrder(order);

            orderService.deleteOrderById(178L);



            System.out.println("Spring bootado");



//            var bikeCategory = new ProductCategory("Bike");
//            var glovesCategory = new ProductCategory("Luva");
//            var squeezerCategory = new ProductCategory("Squeezer");
//            var helmetCategory = new ProductCategory("Helmet");

            //var mountainBike = new Product("Mountain Bike Everest", bikeCategory, BigDecimal.valueOf(2250.00));
//            var bikeCategory = productService.findCategoryById(223L);
//            System.out.println(bikeCategory);
//            bikeCategory.addProduct(null);
//
//            System.out.println(productService.findProductById(354L));

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







        };
    }
}