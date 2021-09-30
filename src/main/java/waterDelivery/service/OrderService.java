package waterDelivery.service;

import org.springframework.stereotype.Service;
import waterDelivery.domain.Order;

import java.util.List;

@Service
public interface OrderService {

    Order saveOrder( Order order );

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    void updateOrder(long id, Order order);

}
