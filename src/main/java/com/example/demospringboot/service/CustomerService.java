package com.example.demospringboot.service;

import com.example.demospringboot.domain.Customer;
import com.example.demospringboot.domain.Order;

import java.util.List;


public interface CustomerService {

    /**
     * Save new employee.
     *
     * @param requestForSave {@link Customer}.
     * @return DTO representation for saved customer.
     */
    Customer saveCustomer(Customer requestForSave);

    List<Customer> getAllUsers();

    Customer getCustomerById(final Long id);

    List<Customer> getCustomerByFirstName(final String firstName);

    List<Customer> getCustomerByLastName(final String lastName);

    List<Customer> getCustomerByPhone(final String phone);

 /*   List<Order> getValues(final String name);

    Customer getCustomerByOrder(final String orderName);*/

    Customer updateCustomer(final Customer customer);

    void removeCustomerById(final Long id);

    void removeAllUsers();

}
