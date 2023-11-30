package com.example.clientmanagement.service;

import com.example.clientmanagement.dto.ProductDto;
import com.example.clientmanagement.exception.CustomerNotFoundException;
import com.example.clientmanagement.mapper.ProductMapper;
import com.example.clientmanagement.model.Product;
import com.example.clientmanagement.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.clientmanagement.mapper.ProductMapper.ProductMapper;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductRepository productRepository;

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::productToDto).toList();
    }

    public ProductDto getProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ProductMapper.productToDto(product.get());
        } else throw new CustomerNotFoundException();
    }

    public void editProduct(Product product) {
        productRepository.save(product);
    }

    public void deletProduct(long id) {
        productRepository.deleteById(id);
    }
    public void addProduct(ProductDto productDto){
        productRepository.save(ProductMapper.dtoToProduct(productDto));
    }

}
