package com.example.ecommerce.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
public class PizzaProduct {
    public enum Size {
        LARGE,
        MEDIUM,
        SMALL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Pizza product name is required")
    @Basic(optional = false)
    private String name;

    private Double price;

    private Size size;

    private String pictureUrl;

    private Byte isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public PizzaProduct(String name, Double price, Size size, String pictureUrl, Byte isDeleted) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.pictureUrl = pictureUrl;
        this.isDeleted = isDeleted;
    }
}
