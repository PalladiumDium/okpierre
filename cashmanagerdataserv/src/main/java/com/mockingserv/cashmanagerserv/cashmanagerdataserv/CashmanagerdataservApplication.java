package com.mockingserv.cashmanagerserv.cashmanagerdataserv;

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.UUID;

@SpringBootApplication
@EnableJpaAuditing
public class CashmanagerdataservApplication {

	public static void main(String[] args) {

		SpringApplication.run(CashmanagerdataservApplication.class, args);

	}


}
