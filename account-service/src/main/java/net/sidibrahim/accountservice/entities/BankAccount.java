package net.sidibrahim.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.sidibrahim.accountservice.enums.AccountType;
import net.sidibrahim.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter @Builder @AllArgsConstructor @NoArgsConstructor @ToString
@Setter
public class BankAccount {
    @Id
    private String id;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Transient
    private Customer customer;
    private Long customerId;
}
