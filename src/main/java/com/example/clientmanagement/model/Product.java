package com.example.clientmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private Order order;


    public Product() {
    }

    public Product(Double price, String name, String info, Order order) {
        this.price = price;
        this.name = name;
        this.info = info;
        this.order = order;

    }

}