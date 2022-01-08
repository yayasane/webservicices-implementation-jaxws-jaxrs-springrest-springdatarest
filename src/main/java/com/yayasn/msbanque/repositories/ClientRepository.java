package com.yayasn.msbanque.repositories;

import com.yayasn.msbanque.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
