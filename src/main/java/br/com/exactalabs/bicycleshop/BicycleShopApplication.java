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

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

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

<<<<<<< HEAD
            var newAdress1 = new Address.AddressBuilder()
                    .street("Camargo Schutz")
                    .district("Vila Prado")
                    .city("São Carlos")
                    .state("São Paulo")
                    .zipCode("13999420")
                    .number("1200")
                    .complement("Próximo ao hospital")
                    .createAddress();


            var newCustomer = new Customer.CustomerBuilder()
                    .name("José")
                    .lastName("Pedro")
                    .cpf("94143295016")
                    .mainPhone("16988888888")
                    .secondaryPhone("")
                    .birthday(LocalDate.of(2020,5,5))
                    .email("josepedro@email.com")
                    .addAddress(newAdress1)
                    .createCustomer();

            System.out.println(newCustomer);

            customerService.saveCustomer(newCustomer);



            var bikeMountain = productService.findProductById(379L);
            var squeezer = productService.findProductById(383L);
            var helmetDragonBorn = productService.findProductById(384L);
=======
            var newAdress = new Address("Rua", "District", "City", "State", "ZipCode", "Number");
            var newCustomer = new Customer("Rodolfo", "Peratello", "16999999999", "", LocalDate.of(2020, 10, 2), newAdress);

            customerService.saveCustomer(newCustomer);

            var bikeMountain = productService.findProductById(255L);
            var squeezer = productService.findProductById(257L);
            var helmetDragonBorn = productService.findProductById(258L);
>>>>>>> develop

            var orderedItens1 = new OrderItem(bikeMountain, 1);
            var orderedItens2 = new OrderItem(squeezer, 1);
            var orderedItens3 = new OrderItem(helmetDragonBorn, 1);

            var creditCardCustomer1 = new CreditCard("4916396776205913", "Giovanna Gonçalves", "231", YearMonth.of(2030, 12));
//            var creditCardCustomer2 = new CreditCard("4539069995203095", "Luiza Cavalcanti", "771", YearMonth.of(2026, 6));
//            var bankSlip1 = new BankSlip("11111111111111111");
//            var bankSlip2 = new BankSlip("99999999999999999");
//
            var order = new Order(newCustomer, creditCardCustomer1);
            order.addOrderedItem(orderedItens1);
            order.addOrderedItem(orderedItens2);
            order.addOrderedItem(orderedItens3);

            orderService.saveOrder(order);

            //orderService.deleteOrderById(188L);



            System.out.println("Spring bootado");

        };
    }
}