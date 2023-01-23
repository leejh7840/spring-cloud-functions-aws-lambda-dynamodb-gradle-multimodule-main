package com.nexient.orders.web.controller;

import com.nexient.orders.data.entity.Order;
import com.nexient.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class SaveOrder implements Function<Order,String> {
    @Autowired
    private OrderService service;

    @Override
    public String apply(Order order) {
        return service.saveOrder(order);
    }
}
