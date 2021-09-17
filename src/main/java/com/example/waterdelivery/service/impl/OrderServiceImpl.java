package com.example.waterdelivery.service.impl;

import com.example.waterdelivery.domain.Order;
import com.example.waterdelivery.exception.NoDataFoundException;
import com.example.waterdelivery.exception.OrderNotFoundException;
import com.example.waterdelivery.repository.OrderRepository;
import com.example.waterdelivery.service.OrderService;

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
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public List<Order> getAllOrders() {

        List<Order> orders = orderRepository.findAll();
        if (orders.isEmpty()) {
            throw new NoDataFoundException();
        }
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        return null;
    }

    @Override
    public void removeOrderById(Long id) {
        orderRepository.delete(orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id)));
    }

    @Override
    public void removeAllOrders() {
        orderRepository.deleteAll();
    }


}
