package com.example.coffee_shop.service;

import com.example.coffee_shop.model.entity.Order;
import com.example.coffee_shop.model.service.OrderAddServiceModel;
import com.example.coffee_shop.model.view.OrderViewModel;

import java.util.List;
import java.util.Set;

public interface OrderService {
    Set<String> findCategoryNames();

    void addOrder(OrderAddServiceModel map);

    List<OrderViewModel> findAllOrders();

    Integer getTotalTime();

    void deleteOrderByName(String orderName);
}
