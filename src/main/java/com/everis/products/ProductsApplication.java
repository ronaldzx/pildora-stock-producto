package com.everis.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
		System.out.println("funciona..");
		SpringApplication.run(ProductsApplication.class, args);
	}

}
