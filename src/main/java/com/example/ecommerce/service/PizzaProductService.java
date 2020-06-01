package com.example.ecommerce.service;

import com.example.ecommerce.model.PizzaProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface PizzaProductService {
    @NotNull Iterable<PizzaProduct> getAllPizzaProducts(Integer pageNo, Integer pageSize, String sortBy, String name, Integer price);

    PizzaProduct getPizzaProduct(@Min(value = 1L, message = "Invalid product ID") long id);
    PizzaProduct save(PizzaProduct product);
    Iterable<PizzaProduct> saveAll(Iterable<PizzaProduct> pizzaProducts);
}
