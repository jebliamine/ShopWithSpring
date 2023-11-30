package com.example.clientmanagement.dto;

import lombok.Builder;

@Builder
public class CustomerDto {
    private long id;
    private String first_name;
    private String last_name;

}
