package waterDelivery.service.impl;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import waterDelivery.domain.Order;
import waterDelivery.exception.NoDataFoundException;
import waterDelivery.exception.OrderNotFoundException;
import waterDelivery.repository.OrderRepository;
import waterDelivery.service.OrderService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        log.info("saveOrder() - start: order = {}", order);
        var savedOrder = orderRepository.save(order);
        log.info("saveOrder() - end: order = {}", savedOrder.getId());
        return savedOrder;
    }

    @Override
    public Order getOrderById(Long id) {
        log.info("orderRepository.findById() - start");
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public List<Order> getAllOrders() {

        List<Order> orders = orderRepository.findAll();
        log.info("orderRepository.findAll() - start");
        if (orders.isEmpty()) {
            log.error("orderRepository.findAll() - exception");
            throw new NoDataFoundException();
        }
        var allOrders = orderRepository.findAll();
        log.info("orderRepository.findAll() - end");
        return allOrders;
    }

    @Override
    public Order updateOrder(Order order) {
        log.info("updateOrder - start");
        return orderRepository.findById(order.getId())
                .map(entity -> {
                    entity.setName(order.getName());
                    entity.setCost(order.getCost());
                    entity.setStatus(order.getStatus());
                    return orderRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id = " + order.getId()));
    }

}
