package waterDelivery.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import waterDelivery.domain.Customer;
import waterDelivery.dto.CustomerDTO;

import java.util.Collection;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO toDto(Customer customer);

    Customer toCustomer(CustomerDTO customerDTO);

    Collection<CustomerDTO> listToDto(Collection<Customer> list);
}
