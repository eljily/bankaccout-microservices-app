package net.sidibrahim.accountservice;

import lombok.AllArgsConstructor;
import net.sidibrahim.accountservice.clients.CustomerRestClient;
import net.sidibrahim.accountservice.entities.BankAccount;
import net.sidibrahim.accountservice.enums.AccountType;
import net.sidibrahim.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
@AllArgsConstructor
public class AccountServiceApplication {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            customerRestClient.allCustomers().forEach(c->{
                BankAccount bankAccount1=BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .accountType(AccountType.CURRENT_ACCOUNT)
                        .createdAt(LocalDate.now())
                        .balance(Math.random()*5446546)
                        .customerId(c.getId())
                        .currency("MRO")
                        .build();
                BankAccount bankAccount2=BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .accountType(AccountType.CURRENT_ACCOUNT)
                        .createdAt(LocalDate.now())
                        .balance(Math.random()*888888)
                        .customerId(c.getId())
                        .currency("MRO")
                        .build();
                bankAccountRepository.save(bankAccount1);
                bankAccountRepository.save(bankAccount2);

            });
            List<BankAccount> bankAccountList= List.of(
                    BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .accountType(AccountType.SAVING_ACCOUNT)
                            .createdAt(LocalDate.now())
                            .balance(876543621)
                            .currency("MRO")
                            .customerId(Long.valueOf(1))
                            .build(),
                    BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .accountType(AccountType.CURRENT_ACCOUNT)
                            .createdAt(LocalDate.now())
                            .balance(853454)
                            .customerId(2l)
                            .currency("MRO")
                            .build()

                    );
            bankAccountRepository.saveAll(bankAccountList);
        };

    }

}
