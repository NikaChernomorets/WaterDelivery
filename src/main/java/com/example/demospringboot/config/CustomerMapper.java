package com.example.demospringboot.config;

import com.example.demospringboot.domain.Customer;
import com.example.demospringboot.dto.CustomerDto;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class CustomerMapper extends CustomMapper<Customer, CustomerDto> {

    @Override
    public void mapBtoA(CustomerDto dto, Customer entity, MappingContext context) {
        super.mapBtoA(dto, entity, context);
    }
}
