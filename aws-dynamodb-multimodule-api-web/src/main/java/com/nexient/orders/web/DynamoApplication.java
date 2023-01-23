package com.nexient.orders.web;

import com.nexient.orders.data.entity.Order;
import com.nexient.orders.service.OrderService;
import com.nexient.orders.web.controller.DeleteOrder;
import com.nexient.orders.web.controller.SaveOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;


@SpringBootApplication(scanBasePackages = {"com.nexient.orders"})
public class DynamoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DynamoApplication.class, args);
	}

}
