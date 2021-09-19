package waterDelivery.config.mapper;

import waterDelivery.dto.CustomerDTO;
import waterDelivery.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper
{
    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );
    
    CustomerDTO toCustomerDto( Customer customer );
}
