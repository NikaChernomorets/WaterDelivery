package waterDelivery.controllers.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import waterDelivery.config.mapper.OrderMapper;
import waterDelivery.domain.Order;
import waterDelivery.dto.orderDTO.OrderCreateDTO;
import waterDelivery.dto.orderDTO.OrderReadDTO;
import waterDelivery.dto.orderDTO.OrderUpdateDTO;
import waterDelivery.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRestControllerImpl implements OrderRestController{

    private final OrderService orderService;

    public OrderRestControllerImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }

    @Override
    @GetMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderReadDTO getById(@PathVariable long id) {
        Order order = orderService.getOrderById(id);
        return OrderMapper.orderINSTANCE.toOrderReadDTO(order);
    }

    @Override
    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderReadDTO saveOrder(@RequestBody OrderCreateDTO requestForSave) {
        Order order = OrderMapper.orderINSTANCE.toSaveOrder(requestForSave);
        return OrderMapper.orderINSTANCE.toOrderReadDTO(orderService.saveOrder(order));
    }

    @Override
    @PutMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderReadDTO updateOrder(@PathVariable("id") long id, @RequestBody OrderUpdateDTO requestForUpdate) {
        Order order = OrderMapper.orderINSTANCE.toUpdateOrder(requestForUpdate);
        orderService.updateOrder(id, order);
        return OrderMapper.orderINSTANCE.toOrderReadDTO(order);
    }

}
