package com.example.coffee_shop.web;

import com.example.coffee_shop.service.OrderService;
import com.example.coffee_shop.service.UserService;
import com.example.coffee_shop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {

        if (!currentUser.isLoggedIn()) {
            return "index";
        }

        model.addAttribute("orders",this.orderService.findAllOrders());
        model.addAttribute("ordersTotalTime",this.orderService.getTotalTime());
        model.addAttribute("employees",this.userService.getAllEmployees());

        return "home";
    }
}

