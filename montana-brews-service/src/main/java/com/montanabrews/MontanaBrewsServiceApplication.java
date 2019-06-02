package com.montanabrews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MontanaBrewsServiceApplication {
	
	public static void main(String[] args) {
		for (String arg: args) {
			System.out.println(arg);
		}
		SpringApplication.run(MontanaBrewsServiceApplication.class, args);
	}
	
}
