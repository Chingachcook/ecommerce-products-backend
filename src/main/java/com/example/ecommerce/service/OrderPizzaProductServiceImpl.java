package com.example.ecommerce.service;

import com.example.ecommerce.model.OrderPizzaProduct;
import com.example.ecommerce.repository.OrderPizzaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Transactional
@Service
public class OrderPizzaProductServiceImpl implements OrderPizzaProductService {

    @Autowired
    OrderPizzaProductRepository orderPizzaProductRepository;

    @Override
    public OrderPizzaProduct create(@NotNull(message = "pizzas for order cannot be null") @Valid OrderPizzaProduct orderPizzaProduct) {
        return this.orderPizzaProductRepository.save(orderPizzaProduct);
    }
}
