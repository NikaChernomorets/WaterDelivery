package com.example.demospringboot.web;

import com.example.demospringboot.config.CustomerConverter;
import com.example.demospringboot.domain.Customer;
import com.example.demospringboot.dto.CustomerDto;
import com.example.demospringboot.service.CustomerService;
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
public class EmployeeRestController {

    private final CustomerService service;
    private final CustomerConverter converter;

    public EmployeeRestController(CustomerService service, CustomerConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new employee", description = "endpoint for creating an entity", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Customer already exists")})
    public CustomerDto saveEmployee(@RequestBody CustomerDto requestForSave) {

        Customer customer = converter.getMapperFacade().map(requestForSave, Customer.class);
        CustomerDto dto = converter.toDto(service.saveCustomer(customer));

        return dto;
    }

    //Получение списка юзеров
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllUsers() {

        return null;
    }

    //Получения юзера по id
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getEmployeeById(@PathVariable long id) {
        Customer entity = service.getCustomerById(id);
        CustomerDto dto = converter.toDto(entity);
        return dto;
    }

    //Обновление юзера
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto refreshEmployee(@PathVariable("id") long id, @RequestBody CustomerDto requestForUpdate) {

        Customer entity = service.getCustomerById(id);
        converter.getMapperFacade().map(requestForUpdate, entity);
        CustomerDto dto = converter.toDto(service.updateCustomer(entity));

        return dto;
    }

    //Удаление по id
    //@DeleteMapping("/users/{id}")
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable long id) {

        service.removeCustomerById(id);
    }

    //Удаление всех юзеров
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        service.removeAllUsers();
    }
}
