package com.example.clientmanagement.service;

import com.example.clientmanagement.dto.ProductDto;
import com.example.clientmanagement.exception.CustomerNotFoundException;
import com.example.clientmanagement.mapper.ProductMapper;
import com.example.clientmanagement.model.Product;
import com.example.clientmanagement.model.ProductImage;
import com.example.clientmanagement.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.clientmanagement.mapper.ProductMapper.ProductMapper;


import java.util.ArrayList;
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
    public void addImagesToProduct(long productId, byte[] imageData){
        // getting the product to modify and handling its existence
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        //creating sample object to fill it with our image data and add it to the product
        ProductImage productImage = new ProductImage();
        productImage.setImagedata(imageData);
        //handling if the products image list is empty
        if (product.getProductImage()== null){
            product.setProductImage(new ArrayList<>());
        }
        // saving product
        product.getProductImage().add(productImage);
        productRepository.save(product);
    }

}
