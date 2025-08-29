package com.ecomm.plugback.Order;
import com.ecomm.plugback.Enums.Status;
import com.ecomm.plugback.Item.ItemEntity;
import com.ecomm.plugback.User.UserEntity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name="orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy="order", cascade=CascadeType.ALL, orphanRemoval =true)
    private List<ItemEntity> items = new ArrayList<>();
}
