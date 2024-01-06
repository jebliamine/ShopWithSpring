package com.example.clientmanagement.mapper;

import com.example.clientmanagement.dto.OrderDto;
import com.example.clientmanagement.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends Mapper {

     static OrderMapper OrderMapper = Mappers.getMapper(OrderMapper.class);

     public Order dtoToOrder(OrderDto orderDto);

     public OrderDto orderToDto(Order order);



}
