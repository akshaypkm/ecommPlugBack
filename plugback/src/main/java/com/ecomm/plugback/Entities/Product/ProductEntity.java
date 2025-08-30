package com.ecomm.plugback.Entities.Product;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;

import com.ecomm.plugback.Enums.Category;

@Entity
@Data
@Table(name = "products")
public class ProductEntity {
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String description;

    @Positive
    private BigDecimal price;

    @Min(100)
    private Integer stock;

    @Enumerated(EnumType.STRING)
    private Category category;     // VISIT - com.ecomm.plugback.Enums.Category - to add/delete enums
}
