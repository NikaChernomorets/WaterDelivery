package com.example.demospringboot.domain;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    List<Customer> findByFirstName(String getFirstName, Pageable pageable);

    Pageable pageableAndSortAscByFirstName = PageRequest.of(0, 10, Sort.by("firstName").ascending());

    List<Customer> findByLastName(String lastName, Pageable pageable);

    Pageable pageableAndSortAscByLastName = PageRequest.of(0, 10, Sort.by("lastName").ascending());

    List<Customer> findByPhone(String phone, Pageable pageable);

    Pageable pageableAndSortAscByPhone = PageRequest.of(0, 10, Sort.by("phone").ascending());

   /* @Query(value = "SELECT id, name FROM Orders WHERE name = orderName INNER JOIN Customers ON Orders.ID = Customers.Order_fk;", nativeQuery = true)
    List<Order> getValues(String orderName);

    List<Customer> findByOrder(String orderName);*/
}
