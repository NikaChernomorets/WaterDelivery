package waterDelivery.config.mapper;

import waterDelivery.dto.CustomerDTO;
import waterDelivery.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper
{
    CustomerMapper customaper = Mappers.getMapper( CustomerMapper.class );
    
    CustomerDTO customerToCustomerDTO( Customer entity );
    
    Customer customerDTOtoCustomer( CustomerDTO dto );
}
