package com.example.coffee_shop.service.impl;

import com.example.coffee_shop.model.entity.Category;
import com.example.coffee_shop.model.entity.Order;
import com.example.coffee_shop.model.entity.UserEntity;
import com.example.coffee_shop.model.service.OrderAddServiceModel;
import com.example.coffee_shop.model.view.OrderViewModel;
import com.example.coffee_shop.repository.OrderRepository;
import com.example.coffee_shop.service.CategoryService;
import com.example.coffee_shop.service.OrderService;
import com.example.coffee_shop.service.UserService;
import com.example.coffee_shop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final UserService userService;


    public OrderServiceImpl(OrderRepository orderRepository, CategoryService categoryService,
                            ModelMapper modelMapper, UserService userService) {
        this.orderRepository = orderRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @Override
    public Set<String> findCategoryNames() {
        return categoryService.findCategoryNames();
    }

    @Override
    public void addOrder(OrderAddServiceModel orderServiceModel) {

        Order order = modelMapper.map(orderServiceModel,Order.class);

        Category category = this.categoryService.findCategoryByName(orderServiceModel.getCategory());
        UserEntity employee = this.userService.findCurrentUser();

        order.setCategory(category)
                .setEmployee(employee);

        //TODO

        this.orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrders() {
        return this.orderRepository.findAll()
                .stream()
                .map(order -> modelMapper.map(order,OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Integer getTotalTime() {
        return findAllOrders().stream()
                .mapToInt(order -> Integer.parseInt(String.valueOf(order.getCategory().getNeededTime())))
                .sum();
    }

    @Override
    public void deleteOrderByName(String orderName) {
        this.orderRepository.deleteByName(orderName);
    }
}
