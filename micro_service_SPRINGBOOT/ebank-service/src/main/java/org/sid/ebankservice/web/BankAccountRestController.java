package org.sid.ebankservice.web;

import org.sid.ebankservice.entites.BankAccount;
import org.sid.ebankservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BankAccountRestController {

    private BankAccountRepository bankAccountRepository;
    public BankAccountRestController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository= bankAccountRepository;
    }
    @GetMapping("/bankAccounts/{id}")
    public  BankAccount getAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
    }
    @PostMapping("bankAccounts")
public BankAccount save(BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
}
    @PutMapping("bankAccounts/{id}")
    public BankAccount update(@RequestBody BankAccount bankAccount, @PathVariable String id){
        bankAccount.setId(id);
        return bankAccountRepository.save(bankAccount);
    }
    @DeleteMapping("bankAccounts/{id}")
    public void delete (@PathVariable String id){
       bankAccountRepository.deleteById(id);
    }
}
