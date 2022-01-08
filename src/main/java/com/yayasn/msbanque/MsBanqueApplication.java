package com.yayasn.msbanque;

import java.util.Date;

import com.yayasn.msbanque.entities.Account;
import com.yayasn.msbanque.entities.AccountType;
import com.yayasn.msbanque.repositories.AccountRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsBanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBanqueApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AccountRepository accountRepository) {
		return args -> {
			accountRepository.save(new Account(null, Math.random() * 9000, new Date(), AccountType.SAVINGS));
			accountRepository.save(new Account(null, Math.random() * 9000, new Date(), AccountType.CURRENT));
			accountRepository.save(new Account(null, Math.random() * 9000, new Date(), AccountType.SAVINGS));
			accountRepository.findAll().forEach(System.out::println);
		};
	}

}
