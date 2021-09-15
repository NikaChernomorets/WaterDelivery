package com.example.demospringboot.repository;

import com.example.demospringboot.domain.Customer;
import com.example.demospringboot.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    List<Customer> findByFirstName(String getFirstName);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByPhone(String phone);

    /*    @Query(value = "SELECT id, name FROM Orders WHERE name = orderName\n" +
                "INNER JOIN Customers ON Orders.ID = Customers.Order_fk;", nativeQuery = true)*/
    List<Order> getValues(String orderName);
    List<Customer> findByOrder(Order order);
}
