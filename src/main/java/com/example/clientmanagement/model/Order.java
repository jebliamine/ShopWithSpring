package com.example.clientmanagement.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate Doo;
    @Transient
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<Product> products;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private TrackingDetails trackingDetails;

    public Double getTotalPrice() {
        for (Product p:this.products){
            totalPrice += p.getPrice();
        }
        return totalPrice;
    }



}
