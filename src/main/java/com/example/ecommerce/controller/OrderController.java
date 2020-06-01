package com.example.ecommerce.controller;

import com.example.ecommerce.dto.OrderPizzaProductDto;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderPizzaProduct;
import com.example.ecommerce.model.OrderStatus;
import com.example.ecommerce.model.ResourceNotFoundException;
import com.example.ecommerce.service.OrderPizzaProductService;
import com.example.ecommerce.service.OrderService;
import com.example.ecommerce.service.PizzaProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.ecommerce.util.Constants.API_BASE;

@RestController
@RequestMapping(API_BASE)
public class OrderController {

    @Autowired
    private PizzaProductService pizzaProductService;

    @Autowired
    private OrderPizzaProductService orderPizzaProductService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderForm form) {
        List<OrderPizzaProductDto> formDtos = form.getPizzaProductOrders();
        validatePizzaProductsExistence(formDtos);

        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderPizzaProduct> orderPizzaProducts = new ArrayList<>();
        for (OrderPizzaProductDto dto : formDtos) {
            orderPizzaProducts.add(orderPizzaProductService.create(new OrderPizzaProduct(order, pizzaProductService.getPizzaProduct(dto
                    .getPizzaProduct()
                    .getId()), dto.getQuantity())));
        }

        order.setOrderPizzaProducts(orderPizzaProducts);

        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    private void validatePizzaProductsExistence(List<OrderPizzaProductDto> orderProductDtos){
        List<OrderPizzaProductDto> list = orderProductDtos
                .stream()
                .filter(op -> Objects.isNull(pizzaProductService.getPizzaProduct(
                        op.getPizzaProduct()
                                .getId())))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)){
            new ResourceNotFoundException("pizza not found");
        }
    }

    private static class OrderForm{

        private List<OrderPizzaProductDto> pizzaProductOrders;

        public List<OrderPizzaProductDto> getPizzaProductOrders(){
            return pizzaProductOrders;
        }

        public void setProductOrders(List<OrderPizzaProductDto> pizzaProductOrders){
            this.pizzaProductOrders = pizzaProductOrders;
        }
    }
}
