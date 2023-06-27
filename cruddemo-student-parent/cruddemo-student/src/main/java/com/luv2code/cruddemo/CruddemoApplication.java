package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	/*
		 CommandLineRunner is from the Spring Framework
		 This method is executed after the Spring Beans have been loaded

	 */
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {

		// Inside the lambda expression we have our custom code
		return runner -> {
			System.out.println("Hello World");
		};
	}

}
