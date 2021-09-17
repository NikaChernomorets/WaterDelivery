package com.example.waterdelivery.config;

import com.example.waterdelivery.domain.Customer;
import com.example.waterdelivery.dto.CustomerDto;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class CustomerMapper extends CustomMapper<Customer, CustomerDto> {

    @Override
    public void mapBtoA(CustomerDto dto, Customer entity, MappingContext context) {
        super.mapBtoA(dto, entity, context);
    }
}
