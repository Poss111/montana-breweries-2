package com.montanabrews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MontanaBrewsServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MontanaBrewsServiceApplication.class);
		app.run(args);
	}
	
}
