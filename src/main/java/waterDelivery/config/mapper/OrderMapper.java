package waterDelivery.config.mapper;

import waterDelivery.dto.OrderDTO;
import waterDelivery.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper
{
    OrderMapper oprdermaper = Mappers.getMapper( OrderMapper.class );
    
    OrderDTO orderToOrderDTO( Order entity );
    
    Order orderDTOtoorder( OrderDTO dto );
}
