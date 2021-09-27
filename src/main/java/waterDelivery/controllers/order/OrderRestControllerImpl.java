package waterDelivery.controllers.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import waterDelivery.config.mapper.OrderMapper;
import waterDelivery.domain.Order;
import waterDelivery.dto.orderDTO.OrderReadDTO;
import waterDelivery.dto.orderDTO.OrderCreateDTO;
import waterDelivery.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRestControllerImpl implements OrderRestController{

    @Autowired
    private OrderService orderService;

    @Override
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }

    @Override
    public OrderReadDTO getById(@PathVariable long id) {
        Order order = orderService.getOrderById(id);
        return OrderMapper.orderINSTANCE.toOrderReadDTO(order);
    }

   /* @Override
    public OrderCreateDTO saveOrder(@RequestBody OrderCreateDTO requestForSave) {
        Order order = OrderMapper.orderINSTANCE.toSaveOrder(requestForSave);
        return OrderMapper.orderINSTANCE.toOrderSaveDTO(orderService.saveOrder(order));
    }*/

}
