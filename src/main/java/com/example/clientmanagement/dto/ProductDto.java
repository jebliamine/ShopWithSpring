package com.example.clientmanagement.dto;

import com.example.clientmanagement.model.ProductImage;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
public class ProductDto {
    private Long id;
    private Double price;
    private String name;
    private String info;
    private List<ProductImage> productImages;

}
