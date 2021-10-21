package com.example.coffee_shop.model.service;

public class UserLoginService {

    private Long id;

    private String username;

    private String password;

    public UserLoginService() {
    }

    public Long getId() {
        return id;
    }

    public UserLoginService setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserLoginService setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginService setPassword(String password) {
        this.password = password;
        return this;
    }


}
