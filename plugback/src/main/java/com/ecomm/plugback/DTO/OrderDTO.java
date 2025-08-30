package com.ecomm.plugback.DTO;

import com.ecomm.plugback.Enums.Status;

import lombok.Data;

import java.time.LocalDateTime;

// import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Data
public class OrderDTO {
    
    private Long userId;

    private Status status;

    private LocalDateTime createdAt;

    private List<OrderItemDTO> items;
}
