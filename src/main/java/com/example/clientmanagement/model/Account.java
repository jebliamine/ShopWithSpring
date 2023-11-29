package com.example.clientmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long id;
    private String user_name;
    private String password;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Customer customer;




    public Account() {
    }

    public Account(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public Account(Long id, String user_name, String password) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
    }



    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
