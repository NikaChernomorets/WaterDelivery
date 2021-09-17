package com.example.waterdelivery.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super(String.format("Order with Id %d not found", id));
    }
}