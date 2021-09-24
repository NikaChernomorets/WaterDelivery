package waterDelivery.service.impl;


import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import waterDelivery.domain.Customer;
import waterDelivery.repository.CustomerRepository;
import waterDelivery.service.CustomerService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Customer saveCustomer(@RequestBody Customer customer) {
        log.info("saveCustomer() - start: customer = {}", customer);
        var savedCustomer = repository.save(customer);
        log.info("saveCustomer() - end: savedCustomer() = {}", savedCustomer.getId());
        return savedCustomer;
    }

    @Override
    public List<Customer> getAllCustomers()
    {
        log.info("repository.findAll() - start");
        var findAllUsers = repository.findAll();
        log.info("findAll() - end");
        return findAllUsers;
    }

    @Override
    public Customer getCustomerById(Long id)
    {   log.info("repository.findById() - start");
        var customer = repository.findById(id)
                .orElseThrow(() ->  new EntityNotFoundException("Customer not found with id = " + id));

        if (customer.getDeleted())
        {   log.error("Customer is Deleted - yes");
            throw new EntityNotFoundException("Customer was deleted with id = " + id);
        }
        log.info("findById() - end");
        return customer;
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName)
    {
        List<Customer> customers = repository.findByFirstName(firstName, CustomerRepository.pageableAndSortAscByFirstName);
        log.info("getCustomerByFirstName - succeed");
        if (customers.toArray().length < 1)
            throw new EntityNotFoundException("Customer not found with firstName = " + firstName);
        for (int i = 0; i < customers.toArray().length; i++)
        {
            if (customers.get(i).getDeleted())
            {
                customers.remove(i--);
            }
        }
        return customers;
    }

    @Override
    public List<Customer> getCustomerByLastName(String lastName)
    {
        List<Customer> customers = repository.findByLastName(lastName, CustomerRepository.pageableAndSortAscByLastName);
        log.info("getCustomerByLastName - succeed");
        if (customers.toArray().length < 1)
            throw new EntityNotFoundException("Customer not found with Lastname = " + lastName);
        for (int i = 0; i < customers.toArray().length; i++)
        {
            if (customers.get(i).getDeleted())
            {
                customers.remove(i--);
            }
        }
        return customers;
    }

    @Override
    public List<Customer> getCustomerByPhone(String phone)
    {
        List<Customer> customers = repository.findByPhone(phone, CustomerRepository.pageableAndSortAscByPhone);
        log.info("getCustomerByPhone - succeed");
        if (customers.toArray().length < 1)
            throw new EntityNotFoundException("Customer not found with phone = " + phone);
        for (int i = 0; i < customers.toArray().length; i++)
        {
            if (customers.get(i).getDeleted())
            {
                customers.remove(i--);
            }
        }
        return customers;
    }


 /*   @Override
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
    {   log.info("updateCustomer - succeed");
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
    {   log.info("removeCustomerById - succeed");
        repository.findById(id)
                .map(customer -> {
                    customer.setDeleted(Boolean.TRUE);
                    return repository.save(customer);
                })
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id = " + id));
    }

    @Override
    public void removeAllCustomers()
    {
        log.info("removeAllCustomers - succeed");
        repository.deleteAll();
    }
}
