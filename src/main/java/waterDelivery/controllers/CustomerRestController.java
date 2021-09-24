package waterDelivery.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import waterDelivery.domain.Customer;
import waterDelivery.domain.Order;
import waterDelivery.dto.CustomerDTO;
import java.util.List;


@RequestMapping("/default")
public interface CustomerRestController {

    @GetMapping("/customers")
    @Operation(summary = "Get All customers", description = "endpoint for getting All customers", tags = {"Customer"})
    @ResponseStatus(HttpStatus.OK)
    List<Customer> getAll();

    @GetMapping("/customers/{id}")
    @Operation(summary = "Get Customer by Id", description = "endpoint for getting C by ID", tags = {"Customer"})
    @ResponseStatus(HttpStatus.OK)
    CustomerDTO getById(@PathVariable long id);

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new customer", description = "endpoint for creating an entity", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Customer already exists")})
    CustomerDTO saveCustomer(CustomerDTO customerDto);

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new Order", description = "endpoint for creating an Order", tags = {"Order"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            })
    Order saveOrder(Order order);
}
