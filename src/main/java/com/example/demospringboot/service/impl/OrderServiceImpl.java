package com.example.demospringboot.service.impl;

import com.example.demospringboot.domain.Order;
import com.example.demospringboot.repository.OrderRepository;
import com.example.demospringboot.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
