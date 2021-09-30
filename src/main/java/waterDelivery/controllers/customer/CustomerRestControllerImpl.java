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

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestControllerImpl implements CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }


    @Override
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerReadDTO getById(@PathVariable long id) {
        Customer customer = customerService.getCustomerById(id);
        return CustomerMapper.INSTANCE.toReadDto(customer);
    }

    @Override
    @GetMapping("/customers/firstname/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerReadDTO> getCustomerByFirstName(@PathVariable String firstName) {
        List<Customer> customers = customerService.getCustomersByFirstName(firstName);
        return CustomerMapper.INSTANCE.toReadDtoList(customers);
    }

    @Override
    @GetMapping("/customers/lastname/{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerReadDTO> getCustomerByLastName(@PathVariable String lastName) {
        List<Customer> customers = customerService.getCustomersByLastName(lastName);
        return CustomerMapper.INSTANCE.toReadDtoList(customers);
    }

    @Override
    @GetMapping("/customers/phone/{phone}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerReadDTO> getCustomerByPhone(@PathVariable String phone) {
        List<Customer> customers = customerService.getCustomersByPhone(phone);
        return CustomerMapper.INSTANCE.toReadDtoList(customers);
    }

    @Override
    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerReadDTO updateCustomer(@PathVariable("id") long id, @RequestBody CustomerUpdateDTO requestForUpd) {
        Customer customer = CustomerMapper.INSTANCE.toUpdateCustomer(requestForUpd);
        return CustomerMapper.INSTANCE.toReadDto(customerService.updateCustomer(id, customer));
    }

    @Override
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerReadDTO saveCustomer(@RequestBody CustomerCreateDTO requestForSave) {
        Customer customer = CustomerMapper.INSTANCE.toSaveCustomer(requestForSave);
        return CustomerMapper.INSTANCE.toReadDto(customerService.saveCustomer(customer));
    }


    @Override
    @PatchMapping("/customers/phone/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhone(@PathVariable Long id, @RequestParam @NotNull String newPhone) {
        customerService.changePhone(newPhone, id);
    }

    @Override
    @PatchMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerReadDTO removeCustomerById(@PathVariable("id") long id) {
        Customer customer = customerService.getCustomerById(id);
        customerService.removeCustomerById(id);
        return CustomerMapper.INSTANCE.toReadDto(customer);
    }
}
