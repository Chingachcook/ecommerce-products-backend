package com.example.ecommerce.repository;

import com.example.ecommerce.model.PizzaProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PizzaProductRepository extends JpaRepository<PizzaProduct, Integer> {
    List<PizzaProduct> findAllByPrice(double price, Pageable pageable);

    Optional<PizzaProduct> findById(long id);
}
