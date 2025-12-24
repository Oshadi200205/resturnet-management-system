package edu.rsm.service;


import edu.rsm.dto.Order;
import edu.rsm.enums.OrderStatus;

import java.util.List;

public interface OrderService {

    void save(Order order);

    List<Order> getAllOrderDetails();

    void deleteById(String id);

    Order getById(String orderId);

    void updateById(String orderId, Order order);

    void updateOrderStatus(String orderId, OrderStatus status);
}
