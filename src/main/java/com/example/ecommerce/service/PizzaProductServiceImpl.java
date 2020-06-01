package com.example.ecommerce.service;

import com.example.ecommerce.model.PizzaProduct;
import com.example.ecommerce.model.ResourceNotFoundException;
import com.example.ecommerce.repository.PizzaProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PizzaProductServiceImpl implements PizzaProductService {

    @Inject
    PizzaProductRepository pizzaProductRepository;

    @Override
    public List<PizzaProduct> getAllPizzaProducts(Integer pageNo, Integer pageSize, String sortBy, String name, Integer price) {
        Sort sortById = Sort.by(sortBy);
        Sort sortByName = Sort.by((List<Sort.Order>) sortById);
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by((List<Sort.Order>) sortByName));

        Page<PizzaProduct> pagedResult = pizzaProductRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<PizzaProduct>();
        }
    }

    @Override
    public PizzaProduct getPizzaProduct(@Min(value = 1L, message = "Invalid product ID") long id) {
        return pizzaProductRepository
                .findById((int) id)
                .orElseThrow(() -> new ResourceNotFoundException("Pizza not found"));
    }

    @Override
    public PizzaProduct save(PizzaProduct pizzaProduct) {
        return pizzaProductRepository.save(pizzaProduct);
    }

    @Override
    public Iterable<PizzaProduct> saveAll(Iterable<PizzaProduct> pizzaProducts) {
        return pizzaProductRepository.saveAll(pizzaProducts);
    }

    public long count() {
        return pizzaProductRepository.count();
    }
}
