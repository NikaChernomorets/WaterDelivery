package waterDelivery.service.impl;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import waterDelivery.domain.Order;
import waterDelivery.exception.NoDataFoundException;
import waterDelivery.exception.OrderIsAlreadyExistException;
import waterDelivery.exception.OrderNotFoundException;
import waterDelivery.repository.OrderRepository;
import waterDelivery.service.OrderService;

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

        if(isExists(order)){
            log.error("customerRepository.save() - exception");
            throw new OrderIsAlreadyExistException();
        }
        else{
            var savedOrder = orderRepository.save(order);
            log.info("saveOrder() - end: order = {}", savedOrder.getId());
            return savedOrder;
        }
    }

    private boolean isExists(Order order) {
        ExampleMatcher modelMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id");

        Example<Order> example = Example.of(order, modelMatcher);
        return orderRepository.exists(example);
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
        else{
            log.info("orderRepository.findAll() - end");
            return orders;
        }
    }


    @Override
    public void updateOrder(long id, Order order) {
        log.info("updateOrder - start");
        orderRepository.findById(id)
                .map(entity -> {
                    entity.setName(order.getName());
                    entity.setCost(order.getCost());
                    entity.setStatus(order.getStatus());
                    return orderRepository.save(entity);
                })
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

}
