package com.example.clientmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Category {
   @Id
   @GeneratedValue
   long id;
   String name;
   String img;
   String description;

   @OneToMany(mappedBy = "category")
   List<Product> Products;
}
