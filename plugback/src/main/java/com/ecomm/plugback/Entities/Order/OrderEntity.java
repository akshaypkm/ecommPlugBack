package com.ecomm.plugback.Entities.Order;
import com.ecomm.plugback.Enums.Status;
import com.ecomm.plugback.Entities.Item.ItemEntity;
import com.ecomm.plugback.Entities.User.UserEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;


@Entity
@Data
@Table(name="orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="userId", nullable = false)
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Min(0)
    private BigDecimal totalAmount;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy="order", cascade=CascadeType.ALL, orphanRemoval =true)
    private List<ItemEntity> items = new ArrayList<>();
}
