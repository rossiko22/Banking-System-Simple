package com.bank.sistem.controller;

import com.bank.sistem.entity.Account;
import com.bank.sistem.exceptions.AccountNotFoundException;
import com.bank.sistem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
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

    @PostMapping
    Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }


}
