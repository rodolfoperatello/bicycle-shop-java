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

            var newAdress = new Address("Rua", "District", "City", "State", "ZipCode", "Number");
            var newCustomer = new Customer("Rodolfo", "Peratello", "16999999999", "", null, newAdress);

            customerService.saveCustomer(newCustomer);

            var bikeMountain = productService.findProductById(340L);
            var squeezer = productService.findProductById(344L);
            var helmetDragonBorn = productService.findProductById(353L);

            var orderedItens1 = new OrderItem(bikeMountain, 1);
            var orderedItens2 = new OrderItem(squeezer, 1);
            var orderedItens3 = new OrderItem(helmetDragonBorn, 1);

            var creditCardCustomer1 = new CreditCard("4916396776205913", "Giovanna Gonçalves", "231", YearMonth.of(2030, 12));
            var creditCardCustomer2 = new CreditCard("4539069995203095", "Luiza Cavalcanti", "771", YearMonth.of(2026, 6));
            var bankSlip1 = new BankSlip("11111111111111111");
            var bankSlip2 = new BankSlip("99999999999999999");

            var order = new Order(newCustomer, creditCardCustomer2);
            order.addOrderedItem(orderedItens1);
            order.addOrderedItem(orderedItens2);
            order.addOrderedItem(orderedItens3);

            orderService.saveOrder(order);

            //orderService.deleteOrderById(179L);

            //System.out.println(orderService.findOrderById(180L));
//            var orderToUpdate = orderService.findOrderById(180L);
//            orderToUpdate.setOrderTotal(BigDecimal.valueOf(0));
//            orderService.updateOrder(orderToUpdate);

            //System.out.println(orderService.findAllOrder(0).getContent().toString());

            System.out.println("Spring bootado");

        };
    }
}