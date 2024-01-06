package com.example.clientmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapper;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class ProductImage {
    @GeneratedValue
    @Id
    long id;
    String type;
    byte[] imagedata;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;

}
