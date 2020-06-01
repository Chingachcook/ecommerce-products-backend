package com.example.ecommerce.util;

import com.example.ecommerce.model.PizzaProduct;
import com.example.ecommerce.service.PizzaProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    PizzaProductService pizzaProductService;

    @Override
    public void run(String...args) throws Exception {
        try {
            PizzaProduct pizzaProduct = new PizzaProduct("Pepperoni", 1350.00, PizzaProduct.Size.LARGE, "url", (byte) 1);
            PizzaProduct pizzaProduct1 = new PizzaProduct("Pepperoni", 1350.00, PizzaProduct.Size.MEDIUM, "url1", (byte) 1);
            PizzaProduct pizzaProduct2 = new PizzaProduct("Pepperoni", 1000.00, PizzaProduct.Size.SMALL, "url2", (byte) 1);
            PizzaProduct pizzaProduct3 = new PizzaProduct("Pepperoni", 1800.00, PizzaProduct.Size.LARGE, "url3", (byte) 1);
            PizzaProduct pizzaProduct4 = new PizzaProduct("Pepperoni", 1500.00, PizzaProduct.Size.LARGE, "url4", (byte) 1);
            PizzaProduct pizzaProduct5 = new PizzaProduct("Pepperoni", 1350.00, PizzaProduct.Size.LARGE, "url5", (byte) 1);
            List<PizzaProduct> pizzaProducts = new ArrayList<>();
            pizzaProducts.add(pizzaProduct);
            pizzaProducts.add(pizzaProduct1);
            pizzaProducts.add(pizzaProduct2);
            pizzaProducts.add(pizzaProduct3);
            pizzaProducts.add(pizzaProduct4);
            pizzaProducts.add(pizzaProduct5);
            pizzaProductService.saveAll(pizzaProducts);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
