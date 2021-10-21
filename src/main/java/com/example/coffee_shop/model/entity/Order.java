package com.example.coffee_shop.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    private String name;

    private BigDecimal price;

    private LocalDateTime orderTime;

    private Category category;

    private String description;

    private UserEntity employee;

    public Order() {
    }

    @Column(name = "name",nullable = false)
    @Size(min = 3,max = 20)
    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    @Positive
    @Column(name = "price",nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Order setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name = "order_time")
    @PastOrPresent
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Order setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public Order setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Column(name = "description",columnDefinition = "LONGTEXT")
    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public Order setDescription(String description) {
        this.description = description;
        return this;
    }

    @ManyToOne
    public UserEntity getEmployee() {
        return employee;
    }

    public Order setEmployee(UserEntity employee) {
        this.employee = employee;
        return this;
    }
}
