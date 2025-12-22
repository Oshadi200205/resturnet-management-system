package edu.rsm.service;


import edu.rsm.dto.Order;

import java.util.List;

public interface OrderService {

    void save(Order order);

    List<Order> getAllOrderDetails();

    void deleteById(String id);

    Order getById(String orderId);

    void updateById(String orderId, Order order);
}
