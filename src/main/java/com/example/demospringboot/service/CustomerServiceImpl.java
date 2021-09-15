package com.example.demospringboot.service;

import com.example.demospringboot.domain.Customer;
import com.example.demospringboot.domain.CustomerRepository;
import com.example.demospringboot.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Customer saveCustomer(@RequestBody Customer requestForSave)
    {
        Customer customer = repository.save(requestForSave);
        return customer;
    }

    @Override
    public List<Customer> getAllUsers()
    {
        return repository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id)
    {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id = " + id));

        if (customer.getIsDeleted())
        {
            throw new EntityNotFoundException("Customer was deleted with id = " + id);
        }

        return customer;
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName)
    {
        List<Customer> customers = repository.findByFirstName(firstName);
        if (customers.toArray().length < 1)
            throw new EntityNotFoundException("Customer not found with firstName = " + firstName);
        for (int i = 0; i < customers.toArray().length; i++)
        {
            if (customers.get(i).getIsDeleted())
            {
                customers.remove(i--);
            }
        }
        return customers;
    }

    @Override
    public List<Customer> getCustomerByLastName(String lastName)
    {
        List<Customer> customers = repository.findByLastName(lastName);
        if (customers.toArray().length < 1)
            throw new EntityNotFoundException("Customer not found with Lastname = " + lastName);
        for (int i = 0; i < customers.toArray().length; i++)
        {
            if (customers.get(i).getIsDeleted())
            {
                customers.remove(i--);
            }
        }
        return customers;
    }

    @Override
    public List<Customer> getCustomerByPhone(String phone)
    {
        List<Customer> customers = repository.findByPhone(phone);
        if (customers.toArray().length < 1)
            throw new EntityNotFoundException("Customer not found with phone = " + phone);
        for (int i = 0; i < customers.toArray().length; i++)
        {
            if (customers.get(i).getIsDeleted())
            {
                customers.remove(i--);
            }
        }
        return customers;
    }

    /*
    @Override
    public Customer getCustomerByOrder(String orderName)
    {
        List<Order> orderList = getValues(orderName);

        if (orderList.toArray().length < 1)
            throw new EntityNotFoundException("Customer not found with phone = " + orderName);
        for (int i = 0; i < orderList.toArray().length; i++)
        {
            if (orderList.get(i).getName() == orderName)
            {
                List<Customer> customers = repository.findAll();
                for (int j = 0; j<customers.toArray().length;j++)
                {
                    if (orderList.get(i).getId()==customers.get(j).getOrder())
                        return customers.get(j);
                }
            }
        }
        return null;
    }
    */
    
    
    @Override
    public Customer updateCustomer(Customer customer)
    {
        return repository.findById(customer.getId())
                .map(entity -> {
                    entity.setFirstName(customer.getFirstName());
                    entity.setLastName(customer.getLastName());
                    entity.setPhone(customer.getPhone());
                    return repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id = " + customer.getId()));
    }

    @Override
    public void removeCustomerById(Long id)
    {
        repository.findById(id)
                .map(customer -> {
                    customer.setIsDeleted(Boolean.TRUE);
                    return repository.save(customer);
                })
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id = " + id));
    }

    @Override
    public void removeAllUsers()
    {
        repository.deleteAll();
    }
}
