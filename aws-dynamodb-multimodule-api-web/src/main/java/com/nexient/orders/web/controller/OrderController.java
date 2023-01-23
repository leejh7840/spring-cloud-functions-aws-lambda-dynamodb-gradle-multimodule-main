package com.nexient.orders.web.controller;

import com.nexient.orders.data.entity.Order;
import com.nexient.orders.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Controller
@AllArgsConstructor
public class OrderController {
    @Autowired
    private OrderService service;

    @Bean  //Spring Cloud Function for get all Orders
    public Supplier<List<Order>> getAllOrder() {

        List<Order> orders = service.getAllOrder();
        return () -> orders;
        //return new GetAllOrder();
    }
    @Bean//Spring Cloud Function for getOrderById
    public Function<String, Optional<Order>> getOrderById() {
        return(input)-> service.getOrder(input);
        // (OR)
        // return (input) -> service.getAllOrder().stream().filter(order -> order.getId().equals(input)).collect(Collectors.toList());
        //return new GetOrderById();
    }
    @Bean //Spring Cloud Function for saveOrder
    public Function<Order,String> saveOrder() {
        return new SaveOrder();
    }
    @Bean  //Spring Cloud Function for deleteOrder
    public Function<String,String> deleteOrder() {
        return new DeleteOrder();
    }

}
