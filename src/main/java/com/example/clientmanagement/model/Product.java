package com.example.clientmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    long id;
    Double price;
    String name;
    String info;




    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
     Order order;

    @ManyToOne
    @JoinColumn(name= "category_id", referencedColumnName = "id")
    Category category;

    @OneToMany(mappedBy = "product")
    List<ProductImage> productImage;

    public Product() {
    }

    public Product(Double price, String name, String info, Order order) {
        this.price = price;
        this.name = name;
        this.info = info;
        this.order = order;

    }

}