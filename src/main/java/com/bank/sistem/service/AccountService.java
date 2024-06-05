package com.bank.sistem.service;

import com.bank.sistem.entity.Account;
import com.bank.sistem.exceptions.AccountNotFoundException;
import com.bank.sistem.exceptions.InsufficientFundsException;
import com.bank.sistem.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public List<Account> findAllAccounts(){
        return accountRepository.findAll();
    }

    public Account findAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account with that id does not exist!"));
    }

    public Account deposit(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account with that id does not exist"));
        account.setAccountBalance(account.getAccountBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdraw(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account with that id does not exist"));
        if (account.getAccountBalance() < amount){
            throw new InsufficientFundsException("There are insufficient funds on the account"); // We check conditions like this and throw Exceptions
        }else{
            account.setAccountBalance(account.getAccountBalance() - amount);
        }
        return accountRepository.save(account);
    }
}
