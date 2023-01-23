package com.nexient.orders.web.controller;

import com.nexient.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class DeleteOrder implements Function<String,String> {
    @Autowired
    private OrderService service;
    @Override
    public String apply(String s) {
        service.deleteOrder(s);
        return "Order Deleted Successfully"+s;
    }
}
