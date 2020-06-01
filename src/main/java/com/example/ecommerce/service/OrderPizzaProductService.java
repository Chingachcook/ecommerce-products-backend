package com.example.ecommerce.service;

import com.example.ecommerce.model.OrderPizzaProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderPizzaProductService {

    OrderPizzaProduct create(@NotNull(message = "pizzas for order cannot be null")
                        @Valid OrderPizzaProduct orderPizzaProduct);
}
