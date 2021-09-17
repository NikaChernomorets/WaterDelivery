package com.example.waterdelivery.web;

import com.example.waterdelivery.config.CustomerConverter;
import com.example.waterdelivery.domain.Customer;
import com.example.waterdelivery.dto.CustomerDto;
import com.example.waterdelivery.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Customer", description = "Customer API")

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestController {

    private final CustomerService service;
    private final CustomerConverter converter;

    public CustomerRestController(CustomerService service, CustomerConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new customer", description = "endpoint for creating an entity", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Customer already exists")})
    public CustomerDto saveCustomer(@RequestBody CustomerDto requestForSave) {

        Customer customer = converter.getMapperFacade().map(requestForSave, Customer.class);
        CustomerDto dto = converter.toDto(service.saveCustomer(customer));

        return dto;
    }

    //Получение списка клиентов
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomers() {

        return null;
    }

    //Получения клиента по id
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerById(@PathVariable long id) {
        Customer entity = service.getCustomerById(id);
        CustomerDto dto = converter.toDto(entity);
        return dto;
    }

    //Обновление клиента
    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto refreshCustomer(@PathVariable("id") long id, @RequestBody CustomerDto requestForUpdate) {

        Customer entity = service.getCustomerById(id);
        converter.getMapperFacade().map(requestForUpdate, entity);
        CustomerDto dto = converter.toDto(service.updateCustomer(entity));

        return dto;
    }

    //Удаление по id
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCustomerById(@PathVariable long id) {

        service.removeCustomerById(id);
    }

    //Удаление всех клиентов
    @DeleteMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllCustomers() {
        service.removeAllCustomers();
    }
}
