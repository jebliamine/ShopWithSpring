package com.example.clientmanagement.service;

import com.example.clientmanagement.exception.CustomerNotFoundException;
import com.example.clientmanagement.model.Order;
import com.example.clientmanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) return order.get();
        else {
            throw new CustomerNotFoundException();
        }
    }

}
