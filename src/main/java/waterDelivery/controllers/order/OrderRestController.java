package waterDelivery.controllers.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import waterDelivery.domain.Order;
import waterDelivery.dto.orderDTO.OrderReadDTO;
import waterDelivery.dto.orderDTO.OrderCreateDTO;

import java.util.List;
@RequestMapping("/default")
public interface OrderRestController {

    @GetMapping("/orders")
    @Operation(summary = "Get All orders", description = "endpoint for getting All orders", tags = {"Order"})
    @ResponseStatus(HttpStatus.OK)
    List<Order> getAll();

    @GetMapping("/customers/{id}")
    @Operation(summary = "Get order by Id", description = "endpoint for getting order by ID", tags = {"Order"})
    @ResponseStatus(HttpStatus.OK)
    OrderReadDTO getById(@PathVariable long id);
/*
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new order", description = "endpoint for creating an entity", tags = {"Order"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Order already exists")})
    OrderCreateDTO saveOrder(OrderCreateDTO orderCreateDto);*/


}
