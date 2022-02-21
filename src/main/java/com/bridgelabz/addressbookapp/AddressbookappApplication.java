package com.bridgelabz.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressbookappApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(AddressbookappApplication.class, args);
		log.info("Address Book app started in the {} Environment", context.getEnvironment().getProperty("environment"));
	}

}
