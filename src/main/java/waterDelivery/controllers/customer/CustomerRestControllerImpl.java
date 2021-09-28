package waterDelivery.controllers.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import waterDelivery.config.mapper.CustomerMapper;
import waterDelivery.domain.Customer;
import waterDelivery.dto.customerDTO.CustomerCreateDTO;
import waterDelivery.dto.customerDTO.CustomerReadDTO;
import waterDelivery.dto.customerDTO.CustomerUpdateDTO;
import waterDelivery.service.CustomerService;
import waterDelivery.service.OrderService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestControllerImpl implements CustomerRestController {

    private final CustomerService customerService;
    private final OrderService orderService;

    public CustomerRestControllerImpl(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

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
    public CustomerUpdateDTO updateCustomer(@PathVariable("id") long id, @RequestBody CustomerUpdateDTO requestForUpd) {
        Customer customer = CustomerMapper.INSTANCE.toUpdateCustomer(requestForUpd);
        return CustomerMapper.INSTANCE.toUpdateDto(customerService.updateCustomer(customer));
    }

    @Override
    public CustomerCreateDTO saveCustomer(@RequestBody CustomerCreateDTO requestForSave) {

        Customer customer = CustomerMapper.INSTANCE.toSaveCustomer(requestForSave);
        return CustomerMapper.INSTANCE.toSaveDto(customerService.saveCustomer(customer));
    }

    @PatchMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhone(@PathVariable Long id, @RequestParam @NotNull String newPhone) {
        customerService.changePhone(newPhone, id);
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
