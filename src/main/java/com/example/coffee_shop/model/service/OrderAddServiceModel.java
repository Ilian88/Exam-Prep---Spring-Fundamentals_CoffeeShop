package com.example.coffee_shop.model.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddServiceModel {

    private Long id;

    private String name;

    private BigDecimal price;

    private LocalDateTime orderTime;

    private String category;

    private String description;

    private String employee;

    public OrderAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public OrderAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderAddServiceModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public OrderAddServiceModel setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getEmployee() {
        return employee;
    }

    public OrderAddServiceModel setEmployee(String employee) {
        this.employee = employee;
        return this;
    }
}
