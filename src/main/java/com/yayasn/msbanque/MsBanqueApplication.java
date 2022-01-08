package com.yayasn.msbanque;

import java.util.Date;

import com.yayasn.msbanque.entities.Account;
import com.yayasn.msbanque.entities.AccountType;
import com.yayasn.msbanque.entities.Client;
import com.yayasn.msbanque.repositories.AccountRepository;
import com.yayasn.msbanque.repositories.ClientRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MsBanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBanqueApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AccountRepository accountRepository, ClientRepository clientRepository,
			RepositoryRestConfiguration restConfiguration) {
		return args -> {
			restConfiguration.exposeIdsFor(Account.class);

			Client client1 = clientRepository.save(new Client(null, "Yaya", null));
			Client client2 = clientRepository.save(new Client(null, "Hassan", null));

			accountRepository.save(new Account(null, Math.random() * 9000, new Date(), AccountType.SAVINGS, client1));
			accountRepository.save(new Account(null, Math.random() * 9000, new Date(), AccountType.CURRENT, client2));
			accountRepository.save(new Account(null, Math.random() * 9000, new Date(), AccountType.SAVINGS, client1));
			accountRepository.findAll().forEach(c -> System.out.println(c.getBalance()));
		};
	}

}
