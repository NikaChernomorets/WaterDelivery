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

import javax.validation.constraints.NotNull;
import java.util.List;


@RequestMapping("/default")
public interface CustomerRestController {


    @Operation(summary = "Get All customers", description = "endpoint for getting All customers", tags = {"Customer"})
    List<Customer> getAll();


    @Operation(summary = "Get Customer by Id", description = "endpoint for getting Customer by ID", tags = {"Customer"})
    CustomerReadDTO getById(@PathVariable long id);


    @Operation(summary = "Get Customer by First Name", description = "endpoint for getting Customer by First name", tags = {"Customer"})
    CustomerReadDTO getCustomerByFirstName(@PathVariable String firstName);


    @Operation(summary = "Get Customer by Last Name", description = "endpoint for getting Customer by Last name", tags = {"Customer"})
    CustomerReadDTO getCustomerByLastName(@PathVariable String lastName);


    @Operation(summary = "Get Customer by phone number", description = "endpoint for getting Customer by phone number", tags = {"Customer"})
    CustomerReadDTO getCustomerByPhone(@PathVariable String phone);


    @Operation(summary = "Update Customer", description = "endpoint for updating Customer", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Customer updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    CustomerUpdateDTO updateCustomer(@PathVariable("id") long id, @RequestBody CustomerUpdateDTO customerUpdateDTO);


    @Operation(summary = "Add a new customer", description = "endpoint for creating an entity", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Customer already exists")})
    CustomerCreateDTO saveCustomer(CustomerCreateDTO customerSaveDto);



    @Operation(summary = "Delete a customer", description = "endpoint for deleting an entity", tags = {"Customer"})
    CustomerDeleteDTO removeCustomerById(@PathVariable("id") long id, @RequestBody CustomerDeleteDTO requestForDel);

    @Operation(summary = "Update customer's phone", description = "endpoint for updating an entity field", tags = {"Customer"})
    void updatePhone(@PathVariable Long id, @RequestParam @NotNull String newPhone);

}
