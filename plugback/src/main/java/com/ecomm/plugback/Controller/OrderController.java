package com.ecomm.plugback.Controller;

import com.ecomm.plugback.DTO.OrderDTO;
import com.ecomm.plugback.DTO.StatusSetDTO;
import com.ecomm.plugback.Entities.Order.OrderEntity;
import com.ecomm.plugback.Services.OrderService;


import java.util.Optional;
import java.util.List;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*; 


@RestController
@RequestMapping("/orders")
public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    //this end goes on a recursion, check 

    // @GetMapping("/")
    // public List<OrderEntity> getOrders(){
    //     return orderService.getOrders();
    // }

    @PostMapping("/addOrder")
    public void addOrder(@RequestBody OrderDTO orderDTO){
        orderService.addOrder(orderDTO);
    }

    @GetMapping("/{id}")
    public Optional<OrderEntity> getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/{id}/status")
    public OrderEntity updateStatus( @PathVariable Long id,@RequestBody StatusSetDTO statusSetDTO){
        return orderService.updateStatus(id, statusSetDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

}
