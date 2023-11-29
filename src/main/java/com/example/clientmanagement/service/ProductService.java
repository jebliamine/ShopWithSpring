package com.example.clientmanagement.service;

import com.example.clientmanagement.dto.ProductDto;
import com.example.clientmanagement.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.clientmanagement.mapper.ProductMapper.ProductMapper;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductRepository productRepository;

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::productToDto).toList();

    }
}
