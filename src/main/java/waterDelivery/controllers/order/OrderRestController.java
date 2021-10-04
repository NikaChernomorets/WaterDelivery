package waterDelivery.controllers.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import waterDelivery.domain.Order;
import waterDelivery.dto.customerDTO.CustomerReadDTO;
import waterDelivery.dto.orderDTO.OrderReadDTO;
import waterDelivery.dto.orderDTO.OrderCreateDTO;
import waterDelivery.dto.orderDTO.OrderUpdateDTO;

import java.util.List;

public interface OrderRestController {


    @Operation(summary = "Get All orders", description = "endpoint for getting All orders", tags = {"Order"})
    List<Order> getAll();


    @Operation(summary = "Get order by Id", description = "endpoint for getting order by ID", tags = {"Order"})
    OrderReadDTO getById(@PathVariable long id);


    @Operation(summary = "Add a new order", description = "endpoint for creating an entity", tags = {"Order"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Order already exists")})
    OrderReadDTO saveOrder(OrderCreateDTO orderCreateDto);


    @Operation(summary = "Update order by Id", description = "endpoint for updating order by ID", tags = {"Order"})
    OrderReadDTO updateOrder(@PathVariable("id") long id, @RequestBody OrderUpdateDTO orderUpdateDTO);

    @Operation(summary = "to order by a client ID", description = "endpoint for adding order by a certain client", tags = {"Order"})
    void addOrderToCustomerByTheirId(@PathVariable long id, @RequestBody OrderCreateDTO requestForSave);
}
