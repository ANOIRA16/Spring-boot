package org.sid.ebankservice;

import org.hibernate.Session;
import org.sid.ebankservice.entites.BankAccount;
import org.sid.ebankservice.enums.AccountType;
import org.sid.ebankservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }
@Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository) {
    return args -> {
        for (int i = 0; i < 10; i++) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            bankAccount.setBalance(Math.random() * 90000);
            bankAccount.setType(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT);
            bankAccount.setCurrency("MAD");
            bankAccountRepository.save(bankAccount);
        }
        bankAccountRepository.findAll().forEach(acc -> {
            System.out.println(acc.toString());
        });
    };
}}