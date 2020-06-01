package com.example.ecommerce.controller;

import com.example.ecommerce.model.PizzaProduct;
import com.example.ecommerce.service.PizzaProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

import static com.example.ecommerce.util.Constants.API_BASE;

@RestController
@RequestMapping(API_BASE + "/pizzas")
public class PizzaProductController {
    @Autowired
    PizzaProductServiceImpl pizzaProductServiceImpl;

    @GetMapping
    public @NotNull ResponseEntity<List<PizzaProduct>> getAllPizzas(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "pizza") String name,
            @RequestParam(defaultValue = "0") Integer price
    ) {
        List<PizzaProduct> pizzaProducts = pizzaProductServiceImpl.getAllPizzaProducts(page, size, sort, name, price);
        Long count = pizzaProductServiceImpl.count();

        return new ResponseEntity<List<PizzaProduct>>(pizzaProducts, new HttpHeaders(), HttpStatus.OK);
    }
}
