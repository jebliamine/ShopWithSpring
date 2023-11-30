package com.example.clientmanagement.mapper;

import com.example.clientmanagement.dto.ProductDto;
import com.example.clientmanagement.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
   static ProductMapper ProductMapper = Mappers.getMapper(ProductMapper.class);

    public  ProductDto productToDto(Product product);
    public Product dtoToProduct(ProductDto productDto);
}
