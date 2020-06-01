package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@NoArgsConstructor
public class OrderPizzaProduct {

    @EmbeddedId
    @JsonIgnore
    private OrderPizzaProductPK pk;

    @Column(nullable = false)
    private Integer quantity;

    public OrderPizzaProduct(OrderPizzaProductPK pk, Integer quantity) {
        this.pk = pk;
        this.quantity = quantity;
    }

    public OrderPizzaProduct(Order order, PizzaProduct pizzaProduct, Integer quantity) {
        pk = new OrderPizzaProductPK();
        pk.setOrder(order);
        pk.setPizzaProduct(pizzaProduct);
        this.quantity = quantity;
    }

    @Transient
    public PizzaProduct getProduct() {
        return this.pk.getPizzaProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    public OrderPizzaProductPK getPk() {
        return pk;
    }

    public void setPk(OrderPizzaProductPK pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
