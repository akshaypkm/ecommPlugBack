package com.ecomm.plugback.Repository;

import com.ecomm.plugback.Entities.Product.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.*;

// import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long>  {
    
    // Optional<ProductEntity> getProducts();

}
