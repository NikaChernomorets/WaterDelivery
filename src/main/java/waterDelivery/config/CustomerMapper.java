package waterDelivery.config;

import waterDelivery.domain.Customer;
import waterDelivery.dto.CustomerDto;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class CustomerMapper extends CustomMapper<Customer, CustomerDto> {

    @Override
    public void mapBtoA(CustomerDto dto, Customer entity, MappingContext context) {
        super.mapBtoA(dto, entity, context);
    }
}
