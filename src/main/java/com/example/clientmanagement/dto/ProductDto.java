package com.example.clientmanagement.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public class ProductDto {
    private Long id;
    private Double price;
    private String name;
    private String info;

}
