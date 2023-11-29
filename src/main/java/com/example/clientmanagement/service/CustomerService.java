package com.example.clientmanagement.service;


import com.example.clientmanagement.exception.CustomerNotFoundException;
import com.example.clientmanagement.model.Customer;

import com.example.clientmanagement.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(long id) {
        Optional<Customer> c = customerRepository.findById(id);
        if (c.isPresent()) return c.get();
        else {
            throw new CustomerNotFoundException();
        }
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deletCustomer(long id) {
        customerRepository.deleteById(id);
    }

    public Customer editCustomer(long id, Customer c) {

        Customer customer = this.getCustomer(id);
        customer.setEmail(c.getEmail());
        customer.setFirst_name(c.getFirst_name());
        customer.setLast_name(c.getLast_name());

        customerRepository.save(customer);
        return customer;
    }

}
