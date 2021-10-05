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
import waterDelivery.dto.orderDTO.OrderCreateDTO;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface CustomerRestController {


    @Operation(summary = "Get All customers", description = "endpoint for getting All customers", tags = {"Customer"})
    List<Customer> getAll();


    @Operation(summary = "Get Customer by Id", description = "endpoint for getting Customer by ID", tags = {"Customer"})
    CustomerReadDTO getById(@PathVariable long id);


    @Operation(summary = "Get Customer by First Name", description = "endpoint for getting Customer by First name", tags = {"Customer"})
    List<CustomerReadDTO> getCustomerByFirstName(@PathVariable String firstName);


    @Operation(summary = "Get Customer by Last Name", description = "endpoint for getting Customer by Last name", tags = {"Customer"})
    List<CustomerReadDTO> getCustomerByLastName(@PathVariable String lastName);


    @Operation(summary = "Get Customer by phone number", description = "endpoint for getting Customer by phone number", tags = {"Customer"})
    List<CustomerReadDTO> getCustomerByPhone(@PathVariable String phone);


    @Operation(summary = "Update Customer", description = "endpoint for updating Customer", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Customer updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    CustomerReadDTO updateCustomer(@PathVariable("id") long id, @RequestBody CustomerUpdateDTO customerUpdateDTO);


    @Operation(summary = "Add a new customer", description = "endpoint for creating an entity", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Customer already exists")})
    CustomerReadDTO saveCustomer(CustomerCreateDTO customerSaveDto);

    @Operation(summary = "Delete a customer", description = "endpoint for deleting an entity", tags = {"Customer"})
    CustomerReadDTO removeCustomerById(@PathVariable("id") long id);

    @Operation(summary = "Update customer's phone", description = "endpoint for updating an entity field", tags = {"Customer"})
    void updatePhone(@PathVariable Long id, @RequestParam @NotNull String newPhone);

    @Operation(summary = "to order by a client ID", description = "endpoint for adding order by a certain client", tags = {"Order"})
    OrderCreateDTO addOrderToCustomerByTheirId(@PathVariable long id, @RequestBody OrderCreateDTO requestForSave);

}
