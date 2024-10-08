package com.example.CRUDApplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.CRUDApplication.service.AccountService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDApplication.model.Account;
import com.example.CRUDApplication.repo.AccountRepo;

@RestController
public class AccountController {

    @Autowired
    public AccountService accountService;

    @PostMapping("/addAccounts")
    public ResponseEntity<Account> addAccounts(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.addAccounts(account), HttpStatus.OK);
    }



    @GetMapping("/getAccounts")
    public ResponseEntity<List<Account>> getAccounts() {

            List<Account> accountList = accountService.getAccounts();

            if(accountList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(accountList, HttpStatus.OK);

    }


    @GetMapping("/getAccounsByID/{id}")
    public ResponseEntity<Account> getAccountsById(@PathVariable Long id) {
       Account account = accountService.getAccountsById(id);

        if(account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @PostMapping("/updateAccountsById{id}")
    public ResponseEntity<Account> updateAccounts(@PathVariable Long id, @RequestBody Account newAccountData) {
        Account account = accountService.updateAccounts(id,newAccountData);

        if (account != null) {


            return new ResponseEntity<>(account,HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/deleteAccountsById{id}")
    public ResponseEntity<HttpStatus> deleteAccounts(@PathVariable Long id) {
        accountService.deleteAccounts(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}

