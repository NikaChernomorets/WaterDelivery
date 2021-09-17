package com.example.demospringboot;

import com.example.demospringboot.domain.Customer;
import com.example.demospringboot.domain.Order;
import com.example.demospringboot.repository.CustomerRepository;
import com.example.demospringboot.service.CustomerService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceTest {

    @Inject
    private CustomerService service;
    @Inject
    private CustomerRepository repository;
    @Inject
    private TestEntityManager testEntityManager;

    @Test
    public void contains_NotValidId_Success() {
        testEntityManager.merge(new Customer(1L, "Wlada", "", "33", Boolean.FALSE, new Order()));
        testEntityManager.merge(new Customer(2L, "Wlada", "", "33", Boolean.FALSE, new Order()));
        Customer isContains = service.getCustomerById(3L);
        assertNull(isContains);
    }

    @Ignore
    @Test
    public void contains_ValidId_Success() {
        Customer object = new Customer(1L, "Wlada", "", "33", Boolean.FALSE, new Order());
        testEntityManager.merge(object);
        boolean isContains = repository.existsById(1L);
        assertEquals(false, isContains);
    }
}
