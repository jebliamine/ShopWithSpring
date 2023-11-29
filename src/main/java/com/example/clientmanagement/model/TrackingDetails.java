package com.example.clientmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class TrackingDetails {
    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String tracking_no;
    private String tracking_status;
    private String tracking_info;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    Order order;



}
