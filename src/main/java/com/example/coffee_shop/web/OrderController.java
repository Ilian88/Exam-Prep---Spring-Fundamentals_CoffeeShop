package com.example.coffee_shop.web;

import com.example.coffee_shop.model.binding.OrderBindingModel;
import com.example.coffee_shop.model.service.OrderAddServiceModel;
import com.example.coffee_shop.service.CategoryService;
import com.example.coffee_shop.service.OrderService;
import com.example.coffee_shop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final CurrentUser currentUser;


    public OrderController(OrderService orderService, ModelMapper modelMapper,
                           CategoryService categoryService, CurrentUser currentUser) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public OrderBindingModel orderBindingModel(){
        return new OrderBindingModel();
    }

    @GetMapping("/add")
    public String addOrder(Model model) {

        if (!currentUser.isLoggedIn()) {
            return "redirect:/users/login";
        }

        model.addAttribute("categories",this.orderService.findCategoryNames());

        return "order-add";
    }

    @PostMapping("/add")
    public String addOrderConfirm(@ModelAttribute @Valid OrderBindingModel orderBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || orderBindingModel.getCategory().isBlank()) {
            redirectAttributes.addFlashAttribute("orderBindingModel",orderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderBindingModel",
                              bindingResult);

            return "redirect:add";
        }


        OrderAddServiceModel orderAddServiceModel = modelMapper.map(orderBindingModel,OrderAddServiceModel.class);

        orderAddServiceModel.setOrderTime(LocalDateTime.parse(
                orderBindingModel.getOrderTime()
                ,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        ));

        this.orderService.addOrder(orderAddServiceModel);

        return "redirect:/";
    }

    @GetMapping("/delete/{name}")
    @Transactional
    public String readyOrder(@PathVariable("name") String orderName){
        this.orderService.deleteOrderByName(orderName);

        return "redirect:/";
    }
}
