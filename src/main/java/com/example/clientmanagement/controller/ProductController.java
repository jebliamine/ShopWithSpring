package com.example.clientmanagement.controller;

import com.example.clientmanagement.dto.ProductDto;
import com.example.clientmanagement.model.Product;
import com.example.clientmanagement.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "Product")
public class ProductController {

    final ProductService productService;

    @PostMapping(path = "/add")
    public void addProduct(@RequestBody ProductDto productdto){
        productService.addProduct(productdto);
    }
}
