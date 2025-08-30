package com.ecomm.plugback.Services;

import com.ecomm.plugback.DTO.OrderDTO;
import com.ecomm.plugback.DTO.OrderItemDTO;
import com.ecomm.plugback.DTO.StatusSetDTO;
import com.ecomm.plugback.Repository.OrderRepository;
import com.ecomm.plugback.Repository.ProductRepository;
import com.ecomm.plugback.Repository.UserRepository;
import com.ecomm.plugback.Entities.Order.OrderEntity;
import com.ecomm.plugback.Entities.User.UserEntity;
import com.ecomm.plugback.Entities.Item.ItemEntity;
import com.ecomm.plugback.Entities.Product.ProductEntity;
import com.ecomm.plugback.Enums.Status;


import java.util.*; 
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.ecomm.plugback.Exceptions.UserNotFoundException;
import com.ecomm.plugback.Exceptions.OutOfStockException;



@Service
public class OrderService {
    
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    public OrderService(OrderRepository orderRepo, ProductRepository productRepo, UserRepository userRepo){
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.userRepo = userRepo;
    }

    public List<OrderEntity> getOrders(){
        try{
             return orderRepo.findAll();
        }
        catch(Exception e){
            throw new RuntimeException("Hello no");
        }
        
    }

    public void deleteOrder(Long id){
        OrderEntity order = orderRepo.findById(id).orElseThrow(()-> new RuntimeException("order not found of that id "+ id));

        orderRepo.delete(order);
    }


    public OrderEntity updateStatus(Long id, StatusSetDTO statusSetDTO){
        OrderEntity existing = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("order not found"));

        existing.setStatus(statusSetDTO.getStatus());

        return orderRepo.save(existing);
    }

    public Optional<OrderEntity> getOrderById(Long id){
        return orderRepo.findById(id);
    }

    public void addOrder(OrderDTO orderDTO){
        UserEntity checkUser = userRepo.findById(orderDTO.getUserId())
                                .orElseThrow(() -> new UserNotFoundException("User not found"));
        
        OrderEntity order = new OrderEntity();
        order.setUser(checkUser);
        order.setStatus(Status.PENDING);

        BigDecimal totalAmount = BigDecimal.ZERO;
        List<ItemEntity> orderItems = new ArrayList<>();

        for(OrderItemDTO item : orderDTO.getItems()){
            Long productId = item.getProductId();
            int quantity = item.getQuantity();

                ProductEntity product = productRepo.findById(productId)
                                .orElseThrow(() -> new RuntimeException("Product not found with id: "+ productId));

                if(product.getStock() < quantity){
                    throw new OutOfStockException("Product "+product.getName() + " has only "+ product.getStock() + " left");
                }            

            product.setStock(product.getStock() - quantity);
            
            ItemEntity orderItem = new ItemEntity();

            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setOrder(order);
            orderItem.setUnitPrice(product.getPrice());


            totalAmount = totalAmount.add(orderItem.getUnitPrice().multiply(BigDecimal.valueOf(quantity)));
        }

        order.setTotalAmount(totalAmount);

        orderRepo.save(order);

        productRepo.saveAll(orderItems.stream().map(ItemEntity::getProduct).toList());
    }



}
