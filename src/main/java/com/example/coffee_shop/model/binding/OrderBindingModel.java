package com.example.coffee_shop.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderBindingModel {

    private String name;

    private BigDecimal price;

    private String orderTime;

    private String category;

    private String description;

    public OrderBindingModel() {
    }

    @Size(min = 3,max = 20)
    @NotBlank
    public String getName() {
        return name;
    }

    public OrderBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public OrderBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }


    public String getOrderTime() {
        return orderTime;
    }

    public OrderBindingModel setOrderTime(String orderTime) {
        this.orderTime = orderTime;
        return this;
    }


    public String getCategory() {
        return category;
    }

    public OrderBindingModel setCategory(String category) {
        this.category = category;
        return this;
    }

    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public OrderBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
