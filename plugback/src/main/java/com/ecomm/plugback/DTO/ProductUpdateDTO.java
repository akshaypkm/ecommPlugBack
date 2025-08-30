package com.ecomm.plugback.DTO;

import com.ecomm.plugback.Enums.Category;

import java.math.BigDecimal;


import lombok.Data;

@Data
public class ProductUpdateDTO {
    private String name;
    
    private String description;

    private BigDecimal price;

    private Integer stock;

    private Category category;
}
