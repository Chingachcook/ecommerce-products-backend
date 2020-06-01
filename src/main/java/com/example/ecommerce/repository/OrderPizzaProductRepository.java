package com.example.ecommerce.repository;

import com.example.ecommerce.model.OrderPizzaProduct;
import com.example.ecommerce.model.OrderPizzaProductPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPizzaProductRepository extends JpaRepository<OrderPizzaProduct, OrderPizzaProductPK> {
}
