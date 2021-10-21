package com.example.coffee_shop.repository;

import com.example.coffee_shop.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    void deleteByName(String orderName);
}
