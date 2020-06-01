package com.example.ecommerce.dto;

import com.example.ecommerce.model.PizzaProduct;
import lombok.Data;

@Data
public class OrderPizzaProductDto {

    private PizzaProduct pizzaProduct;
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public PizzaProduct getPizzaProduct() {
        return pizzaProduct;
    }

    public void setPizzaProduct(PizzaProduct pizzaProduct) {
        this.pizzaProduct = pizzaProduct;
    }
}
