package waterDelivery.service.impl;


import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import waterDelivery.domain.Customer;
import waterDelivery.exception.CustomerIsAlreadyExistException;
import waterDelivery.exception.CustomerNotFoundException;
import waterDelivery.exception.NoDataFoundException;
import waterDelivery.repository.CustomerRepository;
import waterDelivery.service.CustomerService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.customerRepository = repository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("saveCustomer() - start: customer = {}", customer);


        if(isExists(customer)){
            log.error("customerRepository.save() - exception");
            throw new CustomerIsAlreadyExistException();
        }
        else{
            var savedCustomer = customerRepository.save(customer);
            log.info("saveCustomer() - end: savedCustomer() = {}", savedCustomer.getId());
            return savedCustomer;
        }
    }


    public boolean isExists(Customer customer) {
        ExampleMatcher modelMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id");
        Example<Customer> example = Example.of(customer, modelMatcher);
        return customerRepository.exists(example);
    }


    @Override
    public List<Customer> getAllCustomers() {
        log.info("repository.findAll() - start");
        List<Customer> users = customerRepository.findAll();
        if (users.isEmpty()) {
            log.error("customerRepository.findAll() - exception");
            throw new NoDataFoundException();
        } else {
            log.info("findAll() - end");
            return users;
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        log.info("repository.findById() - start");
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        if (customer.getDeleted()) {
            log.error("Customer is Deleted - yes");
            throw new CustomerNotFoundException(id);
        }
        log.info("findById() - end");
        return customer;
    }

    @Override
    public List<Customer> getCustomersByFirstName(String firstName) {
        List<Customer> customers = customerRepository.findByFirstName(firstName, CustomerRepository.pageableAndSortAscByFirstName);

        log.debug("getCustomerByFirstName - succeed");

        if (customers.toArray().length < 1)
            throw new EntityNotFoundException("Customer not found with firstName = " + firstName);
        else
            return customers;
    }

    @Override
    public List<Customer> getCustomersByLastName(String lastName) {
        List<Customer> customers = customerRepository.findByLastName(lastName, CustomerRepository.pageableAndSortAscByLastName);
        log.info("getCustomerByLastName - succeed");
        if (customers.isEmpty())
            throw new EntityNotFoundException("Customer not found with Lastname = " + lastName);
        else
            return customers;


    }

    @Override
    public List<Customer> getCustomersByPhone(String phone) {
        List<Customer> customers = customerRepository.findByPhone(phone, CustomerRepository.pageableAndSortAscByPhone);
        log.info("getCustomerByPhone - succeed");
        if (customers.isEmpty())
            throw new EntityNotFoundException("Customer not found with phone = " + phone);
        else
            return customers;

    }

    @Override
    public void changePhone(String newPhone, Long id) {
        log.info("changePhone() - start");
        customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customerRepository.changeCustomerPhone(newPhone, id);
        log.debug("changePhone() - end");

    }

    //TODO is it needed?
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
    public Customer updateCustomer(Long id, Customer customer) {
        log.info("updateCustomer - succeed");
        return customerRepository.findById(id)
                .map(entity -> {
                    entity.setFirstName(customer.getFirstName());
                    entity.setLastName(customer.getLastName());
                    entity.setPhone(customer.getPhone());
                    return customerRepository.save(entity);
                })
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public void removeCustomerById(Long id) {
        log.info("removeCustomerById - succeed");
        customerRepository.findById(id)
                .map(customer -> {
                    customer.setDeleted(Boolean.TRUE);
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public void removeAllCustomers() {
        log.info("removeAllCustomers - succeed");
        customerRepository.deleteAll();
    }
}
