package waterDelivery.config.mapper;

import waterDelivery.dto.orderDTO.OrderReadDTO;
import waterDelivery.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import waterDelivery.dto.orderDTO.OrderCreateDTO;
import waterDelivery.dto.orderDTO.OrderUpdateDTO;

@Mapper
public interface OrderMapper
{
    OrderMapper orderINSTANCE = Mappers.getMapper( OrderMapper.class );
    
    OrderReadDTO toOrderReadDTO(Order order );
    OrderCreateDTO toOrderSaveDTO(Order order );
    OrderUpdateDTO toOrderUpdateDTO(Order order );

    Order toReadOrder(OrderReadDTO orderReadDTO);
    Order toSaveOrder(OrderCreateDTO orderCreateDTO);
    Order toUpdateOrder(OrderUpdateDTO orderUpdateDTO);
}
