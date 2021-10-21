package com.example.coffee_shop.model.service;

public class OrderHomeService {

    private Long id;

    private String name;

    private Integer numberOfOrders;

    public OrderHomeService() {
    }

    public Long getId() {
        return id;
    }

    public OrderHomeService setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderHomeService setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    public OrderHomeService setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
        return this;
    }
}
