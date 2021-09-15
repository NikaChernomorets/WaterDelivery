package com.example.demospringboot.service;

import com.example.demospringboot.domain.Order;

import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);

    List<Order> getAllOrders();
}
