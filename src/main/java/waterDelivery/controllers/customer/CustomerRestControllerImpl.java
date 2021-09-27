package waterDelivery.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import waterDelivery.config.mapper.CustomerMapper;
import waterDelivery.domain.Customer;
import waterDelivery.dto.customerDTO.CustomerDeleteDTO;
import waterDelivery.dto.customerDTO.CustomerReadDTO;
import org.springframework.web.bind.annotation.*;
import waterDelivery.dto.customerDTO.CustomerCreateDTO;
import waterDelivery.dto.customerDTO.CustomerUpdateDTO;
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
    public CustomerReadDTO getById(@PathVariable long id) {
        Customer customer = customerService.getCustomerById(id);
        return CustomerMapper.INSTANCE.toReadDto(customer);
    }

    @Override
    public CustomerReadDTO getCustomerByFirstName(@PathVariable String firstName) {
        List<Customer> customer = customerService.getCustomerByFirstName(firstName);
        return CustomerMapper.INSTANCE.toReadDto((Customer) customer);
    }

    @Override
    public CustomerReadDTO getCustomerByLastName(@PathVariable String lastName) {
        List<Customer> customer = customerService.getCustomerByLastName(lastName);
        return CustomerMapper.INSTANCE.toReadDto((Customer) customer);
    }

    @Override
    public CustomerReadDTO getCustomerByPhone(@PathVariable String phone) {
        List<Customer> customer = customerService.getCustomerByPhone(phone);
        return CustomerMapper.INSTANCE.toReadDto((Customer) customer);
    }

    @Override
    public  CustomerUpdateDTO updateCustomer(@PathVariable("id") long id, @RequestBody CustomerUpdateDTO requestForUpd){
        Customer customer = CustomerMapper.INSTANCE.toUpdateCustomer(requestForUpd);
        return CustomerMapper.INSTANCE.toUpdateDto(customerService.updateCustomer(customer));
    }


    @Override
    public CustomerCreateDTO saveCustomer(@RequestBody CustomerCreateDTO requestForSave) {
        Customer customer = CustomerMapper.INSTANCE.toSaveCustomer(requestForSave);
        return CustomerMapper.INSTANCE.toSaveDto(customerService.saveCustomer(customer));
    }

    /*@Override
    public CustomerDeleteDTO removeCustomerById(@PathVariable("id") long id, @RequestBody CustomerDeleteDTO requestForDel) {
        Customer customer = CustomerMapper.INSTANCE.toDeleteCustomer(requestForDel);
        return CustomerMapper.INSTANCE.toDeleteDto(customerService.removeCustomerById());*/
/*
    @Override
    public Order saveOrder(@RequestBody Order requestForSave) {
        return orderService.saveOrder(requestForSave);
    }*/


}
