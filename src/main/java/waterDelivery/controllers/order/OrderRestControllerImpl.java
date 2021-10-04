package waterDelivery.controllers.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import waterDelivery.config.mapper.CustomerMapper;
import waterDelivery.config.mapper.OrderMapper;
import waterDelivery.domain.Order;
import waterDelivery.dto.customerDTO.CustomerReadDTO;
import waterDelivery.dto.orderDTO.OrderCreateDTO;
import waterDelivery.dto.orderDTO.OrderReadDTO;
import waterDelivery.dto.orderDTO.OrderUpdateDTO;
import waterDelivery.repository.CustomerRepository;
import waterDelivery.service.CustomerService;
import waterDelivery.service.OrderService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRestControllerImpl implements OrderRestController {

    private final OrderService orderService;
    private final CustomerService customerService;

    public OrderRestControllerImpl(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
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

    @Override
    @PatchMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addOrderToCustomerByTheirId(@PathVariable long id, OrderCreateDTO requestForSave) {
        Order order = OrderMapper.orderINSTANCE.toSaveOrder(requestForSave);
        if(customerService.getCustomerById(id).;)
    }
}

