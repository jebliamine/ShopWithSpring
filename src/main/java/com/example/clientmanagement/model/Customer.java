package com.example.clientmanagement.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Customer {
   @Id
   @SequenceGenerator(
           name = "customer_sequence",
           sequenceName = "costumer_sequence",
           allocationSize = 1
   )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "customer_sequence"
   )
   private long id ;
   private String first_name;
   private String last_name;
   private String email;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "account_id",referencedColumnName = "id")
   private Account account;

   @OneToMany(mappedBy = "customer")
   private List <Order> orders;


   public Customer(String first_name, String last_name, String email, Account account, List<Order> orders) {
      this.first_name = first_name;
      this.last_name = last_name;
      this.email = email;
      this.account = account;
      this.orders = orders;
   }

   public Customer() {

   }



   @Override
   public String toString() {
      return "Costumer{" +
              "id=" + id +
              ", first_name='" + first_name + '\'' +
              ", last_name='" + last_name + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}
