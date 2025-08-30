package com.ecomm.plugback.Repository;

import com.ecomm.plugback.Entities.Product.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long>  {
    
    // Optional<ProductEntity> getProducts();

}
