package com.example.coffee_shop.model.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user_entities")
public class UserEntity extends BaseEntity{

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private List<Order> orders;


    public UserEntity() {
    }

    @Column(name = "username",unique = true)
    @Size(min = 5,max = 20)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name",nullable = false)
    @Size(min = 5,max = 20)
    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(name = "password",nullable = false)
    @Size(min = 3)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(name = "email",unique = true,nullable = false)
    @Email
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER)
    public List<Order> getOrders() {
        return orders;
    }

    public UserEntity setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }
}
