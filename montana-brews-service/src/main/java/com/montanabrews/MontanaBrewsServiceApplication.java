package com.montanabrews;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MontanaBrewsServiceApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MontanaBrewsServiceApplication.class);
//		app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
		app.run(args);
	}
}
