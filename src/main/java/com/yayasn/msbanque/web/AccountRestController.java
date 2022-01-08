package com.yayasn.msbanque.web;

import java.util.List;

import com.yayasn.msbanque.entities.Account;
import com.yayasn.msbanque.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class AccountRestController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping(path = "/accounts", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Account> accountsList() {
        return accountRepository.findAll();
    }

    @GetMapping(path = "/accounts/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public Account getOne(@PathVariable Long id) {
        return accountRepository.findById(id).get();
    }

    @PostMapping(path = "/accounts", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Account save(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @PutMapping(path = "/accounts/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public Account update(@RequestBody Account account, @PathVariable(value = "id") Long id) {
        account.setId(id);
        return accountRepository.save(account);
    }

    @DeleteMapping("/accounts/{id}")
    public void delete(@PathVariable Long id) {
        accountRepository.deleteById(id);
    }
}
