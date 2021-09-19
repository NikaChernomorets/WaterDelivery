package waterDelivery.config.mapper;

import waterDelivery.dto.OrderDTO;
import waterDelivery.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper
{
    OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );
    
    OrderDTO toOrderDto( Order order );
}
