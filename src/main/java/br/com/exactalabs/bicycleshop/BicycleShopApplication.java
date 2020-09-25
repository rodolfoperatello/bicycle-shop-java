package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.Address;
import br.com.exactalabs.bicycleshop.entity.Customer;
import br.com.exactalabs.bicycleshop.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BicycleShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BicycleShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return args -> {

            var clientService = appContext.getBean(CustomerService.class);

            var customerAdress = new Address("Rua Oliveira", "My District", "Araxá", "Minas Gerais",
                    "38181-564",  "1652");
            var customerAdress2 = new Address("Rua Dezesseis", "My District", "Rio de Janeiro", "Rio de Janeiro",
                    "20972-200",  "1822");

            var customer = new Customer("Luiza", "Cavalcanti", "(21) 9744-8535",
                    "", LocalDate.of(1991, 10,10), customerAdress);
            //customer.addAdress(null);



            System.out.println(clientService.saveClient(customer));



            System.out.println("Spring bootado!");





        };
    }

}
