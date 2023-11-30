package com.example.clientmanagement.mapper;

import com.example.clientmanagement.dto.CustomerDto;
import com.example.clientmanagement.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CustomerMapper extends Mapper {
    static CustomerMapper CustomerMapper = Mappers.getMapper(CustomerMapper.class);

    public  Customer dtoToCustomer(CustomerDto customerDto);
    public CustomerDto customerToDto(Customer customer);


}
