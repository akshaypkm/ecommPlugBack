package com.ecomm.plugback.Entities.Item;
import com.ecomm.plugback.Entities.Order.OrderEntity;
import com.ecomm.plugback.Entities.Product.ProductEntity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;




import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "items")
public class ItemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private ProductEntity product;

    @Min(0)
    private int quantity;

    @Positive
    private BigDecimal unitPrice;
}
