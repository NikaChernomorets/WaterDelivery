package waterDelivery.controllers.customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import waterDelivery.domain.Customer;
import waterDelivery.domain.Order;
import waterDelivery.dto.customerDTO.CustomerDeleteDTO;
import waterDelivery.dto.customerDTO.CustomerReadDTO;
import waterDelivery.dto.customerDTO.CustomerCreateDTO;
import waterDelivery.dto.customerDTO.CustomerUpdateDTO;

import java.util.List;


@RequestMapping("/default")
public interface CustomerRestController {

    @GetMapping("/customers")
    @Operation(summary = "Get All customers", description = "endpoint for getting All customers", tags = {"Customer"})
    @ResponseStatus(HttpStatus.OK)
    List<Customer> getAll();

    @GetMapping("/customers/{id}")
    @Operation(summary = "Get Customer by Id", description = "endpoint for getting Customer by ID", tags = {"Customer"})
    @ResponseStatus(HttpStatus.OK)
    CustomerReadDTO getById(@PathVariable long id);

    @GetMapping("/customers/{firstName}")
    @Operation(summary = "Get Customer by First Name", description = "endpoint for getting Customer by First name", tags = {"Customer"})
    @ResponseStatus(HttpStatus.OK)
    CustomerReadDTO getCustomerByFirstName(@PathVariable String firstName);

    @GetMapping("/customers/{lastName}")
    @Operation(summary = "Get Customer by Last Name", description = "endpoint for getting Customer by Last name", tags = {"Customer"})
    @ResponseStatus(HttpStatus.OK)
    CustomerReadDTO getCustomerByLastName(@PathVariable String lastName);

    @GetMapping("/customers/{phone}")
    @Operation(summary = "Get Customer by phone number", description = "endpoint for getting Customer by phone number", tags = {"Customer"})
    @ResponseStatus(HttpStatus.OK)
    CustomerReadDTO getCustomerByPhone(@PathVariable String phone);

    @PutMapping("/customers")
    @Operation(summary = "Update Customer", description = "endpoint for updating Customer", tags = {"Customer"})
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Customer updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    CustomerUpdateDTO updateCustomer(@PathVariable("id") long id, @RequestBody CustomerUpdateDTO customerUpdateDTO);

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new customer", description = "endpoint for creating an entity", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Customer already exists")})
    CustomerCreateDTO saveCustomer(CustomerCreateDTO customerSaveDto);

    /*@DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a customer", description = "endpoint for deleting an entity", tags = {"Customer"})
    CustomerDeleteDTO removeCustomerById(@PathVariable("id") long id, @RequestBody CustomerDeleteDTO requestForDel);*/

/*    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new Order", description = "endpoint for creating an Order", tags = {"Order"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            })
    Order saveOrder(Order order);*/

}
