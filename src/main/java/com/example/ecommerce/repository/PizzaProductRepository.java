package com.example.ecommerce.repository;

import com.example.ecommerce.model.PizzaProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaProductRepository extends PagingAndSortingRepository<PizzaProduct, Integer> {
    List<PizzaProduct> findAllByPrice(double price, Pageable pageable);
}
