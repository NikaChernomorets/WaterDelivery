package waterDelivery.config;

import waterDelivery.domain.Customer;
import waterDelivery.dto.CustomerDto;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

public class MappingConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(Customer.class, CustomerDto.class )
                .customize(new CustomerMapper())
                .byDefault()
                .register();

        mapperFactory.classMap(Customer.class, CustomerDto.class)
                .byDefault()
                .register();
    }
}
