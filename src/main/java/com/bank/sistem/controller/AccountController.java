package com.bank.sistem.controller;

import com.bank.sistem.entity.Account;
import com.bank.sistem.exceptions.AccountNotFoundException;
import com.bank.sistem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    List<Account> findAllAccounts(){
        return accountService.findAllAccounts();
    }

    @GetMapping("/{id}")
    Account findAccountById(@PathVariable Long id){
            return accountService.findAccountById(id);
    }

    @PostMapping("/create")
    Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    //Here we can pass Map , which is like dictonary in python and it maps that map in json
    //for example if we put first string "depositAmount", and second int 1234 it is mapped string double
    //it can work with that kind of parameter, for anything more we can learn additonally later
    @PostMapping("/{id}/deposit")
    Account depositToAccount(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("depositAmount");
        return accountService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    Account withdrawFromAccount(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("withdrawAmount");
        return accountService.withdraw(id, amount);
    }




}
