package com.ecomm.plugback.DTO;

import com.ecomm.plugback.Enums.Category;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProductAddDTO {
    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private BigDecimal price;

    private Integer stock;

    @NotBlank
    private Category category;
}
