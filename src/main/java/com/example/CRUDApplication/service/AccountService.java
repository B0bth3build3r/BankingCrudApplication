package com.example.CRUDApplication.service;

import com.example.CRUDApplication.model.Account;
import com.example.CRUDApplication.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AccountService {


    @Autowired
    private AccountRepo accountRepo;


    public Account addAccounts(Account account) {
        return accountRepo.save(account);

    }

    public List<Account> getAccounts() {
        try {

            return accountRepo.findAll();

        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    public Account getAccountsById(Long id) {
        Optional<Account> accountData = accountRepo.findById(id);

        return accountData.orElse(null);
    }

    public Account updateAccounts(Long id, Account newAccountData) {
        Optional<Account> oldAccountData = accountRepo.findById(id);

        if (oldAccountData.isPresent()) {
            Account updatedAccountData = oldAccountData.get();
            updatedAccountData.setAccountNumber(newAccountData.getAccountNumber());
            updatedAccountData.setAccountHolderName(newAccountData.getAccountHolderName());
            updatedAccountData.setAccountType(newAccountData.getAccountType());
            updatedAccountData.setBalance(newAccountData.getBalance());

            return accountRepo.save(updatedAccountData);

        }
        return null;


    }

    public void deleteAccounts(Long id) {
        accountRepo.deleteById(id);
    }

}




