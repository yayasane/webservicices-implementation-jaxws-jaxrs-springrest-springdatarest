package com.yayasn.msbanque.web;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yayasn.msbanque.entities.Account;
import com.yayasn.msbanque.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/bank")
public class AccountRestJaxRSAPI {
    @Autowired
    private AccountRepository accountRepository;

    @Path("/accounts")
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Account> accountsList() {
        return accountRepository.findAll();
    }

    @Path("/accounts/{id}")
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Account getOne(@PathParam(value = "id") Long id) {
        return accountRepository.findById(id).get();
    }

    @Path("/accounts")
    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Path("/accounts/{id}")
    @PUT
    @Produces({ MediaType.APPLICATION_JSON })
    public Account update(Account account, @PathParam(value = "id") Long id) {
        account.setId(id);
        return accountRepository.save(account);
    }

    @Path("/accounts/{id}")
    @DELETE
    @Produces({ MediaType.APPLICATION_JSON })
    public void delete(@PathParam(value = "id") Long id) {
        accountRepository.deleteById(id);
    }
}
