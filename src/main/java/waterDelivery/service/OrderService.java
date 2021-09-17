package waterDelivery.service;

import waterDelivery.domain.Order;

import java.util.List;

public interface OrderService {

    Order saveOrder( Order order );

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    Order updateOrder(final Order order);

    void removeOrderById(final Long id);

    void removeAllOrders();
}
