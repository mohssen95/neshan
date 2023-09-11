package com.example.foodi.service;

import com.example.foodi.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order addOrder(Order order);
    Optional<Order> getOrder(Long id);
    List<Order>getAll();

}
