package com.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionReportApplication.class, args);

		System.out.println("Welcome to transaction report");
	}

}
