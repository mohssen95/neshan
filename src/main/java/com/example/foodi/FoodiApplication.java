package com.example.foodi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FoodiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodiApplication.class, args);
	}

}
