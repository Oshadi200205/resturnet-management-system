package edu.rsm.controller;

import edu.rsm.dto.Order;
import edu.rsm.enums.OrderStatus;
import edu.rsm.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderService.save(order);
    }

    @GetMapping("/getAll")
    public List<Order> getAll(){
        return orderService.getAllOrderDetails();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        orderService.deleteById(id);
    }

    @GetMapping("/{di}")
    public Order getById(@PathVariable String orderId){
        return orderService.getById(orderId);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable("id")String orderId,@RequestBody Order order){
         orderService.updateById(orderId,order);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable("id") String orderId, @RequestParam OrderStatus status){
        orderService.updateOrderStatus(orderId , status );
    }

}
