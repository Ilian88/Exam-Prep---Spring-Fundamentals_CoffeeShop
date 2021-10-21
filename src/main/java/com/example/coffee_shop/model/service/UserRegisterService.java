package com.example.coffee_shop.model.service;

public class UserRegisterService {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    public UserRegisterService() {
    }

    public Long getId() {
        return id;
    }

    public UserRegisterService setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterService setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterService setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterService setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterService setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterService setEmail(String email) {
        this.email = email;
        return this;
    }
}
