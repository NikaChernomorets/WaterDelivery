package waterDelivery.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import waterDelivery.domain.Customer;
import waterDelivery.dto.customerDTO.CustomerDeleteDTO;
import waterDelivery.dto.customerDTO.CustomerReadDTO;
import waterDelivery.dto.customerDTO.CustomerCreateDTO;
import waterDelivery.dto.customerDTO.CustomerUpdateDTO;


@Mapper (componentModel = "spring")
public interface CustomerMapper
{
    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );
    
    CustomerReadDTO toReadDto(Customer customer );
    CustomerCreateDTO toSaveDto(Customer customer );
    CustomerUpdateDTO toUpdateDto(Customer customer );
    CustomerDeleteDTO toDeleteDto(Customer customer );

    Customer toSaveCustomer(CustomerCreateDTO customerSaveDTO);
    Customer toReadCustomer(CustomerReadDTO customerReadDTO);
    Customer toUpdateCustomer(CustomerUpdateDTO customerUpdateDTO);
    Customer toDeleteCustomer(CustomerDeleteDTO customerDeleteDTO);


}