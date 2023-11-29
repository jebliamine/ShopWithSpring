package com.example.clientmanagement.controller;

import com.example.clientmanagement.model.Customer;


import com.example.clientmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Customers")
public class CostumerController {
    private final CustomerService customerService;


    @Autowired
    public CostumerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCostumer(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{id}")
    public Customer getCostumer(@PathVariable("id") long id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer){customerService.addCustomer(customer);}

}
