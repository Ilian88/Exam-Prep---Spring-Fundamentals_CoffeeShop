package com.example.coffee_shop.model.view;

public class UserViewModel {

    private String firstName;

    private Integer numberOfOrders;

    public UserViewModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    public UserViewModel setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
        return this;
    }
}
