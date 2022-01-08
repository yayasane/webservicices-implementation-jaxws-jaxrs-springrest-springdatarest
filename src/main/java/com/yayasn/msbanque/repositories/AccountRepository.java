package com.yayasn.msbanque.repositories;

import java.util.List;

import com.yayasn.msbanque.entities.Account;
import com.yayasn.msbanque.entities.AccountType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {
    @RestResource(path = "/byType")
    List<Account> findByType(@Param("t") AccountType type);
}
