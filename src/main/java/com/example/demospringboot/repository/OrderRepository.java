package com.example.demospringboot.repository;

import com.example.demospringboot.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
