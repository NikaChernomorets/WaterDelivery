package com.example.demospringboot.config;

import com.example.demospringboot.domain.Customer;
import com.example.demospringboot.dto.CustomerDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    private final MapperFacade mapperFacade;

    public CustomerConverter(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    public MapperFacade getMapperFacade() {
        return mapperFacade;
    }

    public CustomerDto toDto(Customer entity) {
        return mapperFacade.map(entity, CustomerDto.class);
    }

    public Customer fromDto(CustomerDto dto) {
        return mapperFacade.map(dto, Customer.class);
    }
}
