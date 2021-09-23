package waterDelivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import waterDelivery.config.mapper.CustomerMapper;
import waterDelivery.domain.Customer;
import waterDelivery.domain.Order;
import waterDelivery.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;
import waterDelivery.service.CustomerService;
import waterDelivery.service.OrderService;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestControllerImpl implements CustomerRestController{

    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;

    @Override
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }

    @Override
    public CustomerDTO getById(@PathVariable long id) {
        Customer customer = customerService.getCustomerById(id);
        return CustomerMapper.INSTANCE.toDto(customer);
    }

    @Override
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO requestForSave) {
        Customer customer = CustomerMapper.INSTANCE.toCustomer(requestForSave);
        return CustomerMapper.INSTANCE.toDto(customerService.saveCustomer(customer));
    }

    @Override
    public Order saveOrder(@RequestBody Order requestForSave) {
        return orderService.saveOrder(requestForSave);
    }


}
