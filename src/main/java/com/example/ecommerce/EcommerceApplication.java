package com.example.ecommerce;

import com.example.ecommerce.model.PizzaProduct;
import com.example.ecommerce.service.PizzaProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PizzaProductService pizzaProductService) {
		return args -> {
			pizzaProductService.save(new PizzaProduct("Pepperoni", 1350.00, PizzaProduct.Size.LARGE, "http://pngimg.com/uploads/pizza/pizza_PNG43985.png", (byte) 1));
			pizzaProductService.save(new PizzaProduct("Pepperoni", 1350.00, PizzaProduct.Size.MEDIUM, "http://pngimg.com/uploads/pizza/pizza_PNG43985.png", (byte) 1));
			pizzaProductService.save(new PizzaProduct("Pepperoni", 1000.00, PizzaProduct.Size.SMALL, "http://pngimg.com/uploads/pizza/pizza_PNG43985.png", (byte) 1));
			pizzaProductService.save(new PizzaProduct("Pepperoni", 1800.00, PizzaProduct.Size.LARGE, "http://pngimg.com/uploads/pizza/pizza_PNG43985.png", (byte) 1));
			pizzaProductService.save(new PizzaProduct("Pepperoni", 1500.00, PizzaProduct.Size.LARGE, "http://pngimg.com/uploads/pizza/pizza_PNG43985.png", (byte) 1));
			pizzaProductService.save(new PizzaProduct("Pepperoni", 1350.00, PizzaProduct.Size.LARGE, "http://pngimg.com/uploads/pizza/pizza_PNG43985.png", (byte) 1));
			pizzaProductService.save(new PizzaProduct("Pepperoni", 1350.00, PizzaProduct.Size.SMALL, "http://pngimg.com/uploads/pizza/pizza_PNG43985.png", (byte) 1));
			pizzaProductService.save(new PizzaProduct("Pepperoni", 1200.00, PizzaProduct.Size.LARGE, "http://pngimg.com/uploads/pizza/pizza_PNG43985.png", (byte) 1));
			pizzaProductService.save(new PizzaProduct("Pepperoni", 1350.00, PizzaProduct.Size.LARGE, "http://pngimg.com/uploads/pizza/pizza_PNG43985.png", (byte) 1));
		};
	}


}
