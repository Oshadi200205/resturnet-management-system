package edu.rsm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.rsm.dto.Order;
import edu.rsm.entity.OrderEntity;
import edu.rsm.enums.OrderStatus;
import edu.rsm.repository.OrderRepository;
import edu.rsm.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ObjectMapper mapper;

    @Override
    public void save(Order order) {
        orderRepository.save(mapper.convertValue(order, OrderEntity.class));
    }

    @Override
    public List<Order> getAllOrderDetails() {
        return orderRepository.findAll()
                .stream()
                .map(orderEntity -> mapper.convertValue(orderEntity,Order.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getById(String orderId) {
        return  toDto(getEntity(orderId));
    }

    @Override
    public void updateById(String orderId, Order order) {
        getEntity(orderId);
        OrderEntity toSave = toEntity(order);
        toSave.setId(orderId);
        orderRepository.save(toSave);

    }

    @Override
    public void updateOrderStatus(String orderId, OrderStatus status) {
        OrderEntity orderEntity = orderRepository.findById(orderId)
                .orElseThrow();
        orderEntity.setStatus(status);
        orderRepository.save(orderEntity);
    }

    private OrderEntity getEntity(String id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order Is Not Available"));
    }

    private Order toDto(OrderEntity entity){
        return mapper.convertValue(entity, Order.class);
    }

    private OrderEntity toEntity(Order dto){
        return mapper.convertValue(dto, OrderEntity.class);
    }
}
