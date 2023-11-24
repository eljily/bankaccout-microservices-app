package net.sibrahim.customerservice;

import lombok.AllArgsConstructor;
import net.sibrahim.customerservice.config.GlobalConfig;
import net.sibrahim.customerservice.entities.Customer;
import net.sibrahim.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            List<Customer>  customerList=List.of(
                    Customer.builder()
                            .email("sidi@gmail.com")
                            .firstName("sidi")
                            .lastName("med")
                            .build(),
                    Customer.builder()
                            .email("Khaled@gmail.com")
                            .firstName("Khaled")
                            .lastName("Zeinidine")
                            .build(),
                    Customer.builder()
                            .lastName("Oumar")
                            .firstName("Jibril")
                            .email("oumar@gmail.com")
                            .build());
            customerRepository.saveAll(customerList);
        };
    }

}
