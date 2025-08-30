package com.ecomm.plugback.Repository;

import com.ecomm.plugback.Entities.Order.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
    
}
