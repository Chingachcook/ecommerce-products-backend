package com.example.ecommerce;

import com.example.ecommerce.model.PizzaProduct;
import com.example.ecommerce.service.PizzaProductService;
import com.example.ecommerce.util.CommandLineAppStartupRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(PizzaProductService pizzaProductService) {
//		return args -> {
//			pizzaProductService.save(new PizzaProduct("Pepperoni", 1350.00, PizzaProduct.Size.LARGE, "url", (byte) 1));
//			pizzaProductService.save(new PizzaProduct("Pepperoni", 1350.00, PizzaProduct.Size.MEDIUM, "url1", (byte) 1));
//			pizzaProductService.save(new PizzaProduct("Pepperoni", 1000.00, PizzaProduct.Size.SMALL, "url2", (byte) 1));
//			pizzaProductService.save(new PizzaProduct("Pepperoni", 1800.00, PizzaProduct.Size.LARGE, "url3", (byte) 1));
//			pizzaProductService.save(new PizzaProduct("Pepperoni", 1500.00, PizzaProduct.Size.LARGE, "url4", (byte) 1));
//			pizzaProductService.save(new PizzaProduct("Pepperoni", 1350.00, PizzaProduct.Size.LARGE, "url5", (byte) 1));
//		};
//	}


}
