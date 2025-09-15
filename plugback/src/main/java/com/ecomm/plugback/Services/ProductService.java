package com.ecomm.plugback.Services;

import com.ecomm.plugback.Configurations.AppConfig;
import com.ecomm.plugback.DTO.ProductAddDTO;
import com.ecomm.plugback.DTO.ProductUpdateDTO;
import com.ecomm.plugback.Repository.ProductRepository;
import com.ecomm.plugback.Entities.Product.ProductEntity;

import java.util.Optional;
import java.util.List;

import org.springframework.data.domain.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    
    private final ModelMapper modelMapper;
    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo, ModelMapper modelMapper){
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
    }
    
    public Page<ProductEntity> getProducts(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return productRepo.findAll(pageable);
    }

    public Optional<ProductEntity> getProductsById(Long id){
        return productRepo.findById(id);
    }

    public ProductEntity addProduct(ProductAddDTO productAddDTO){
        ProductEntity productEntity = modelMapper.map(productAddDTO, ProductEntity.class);
        return productRepo.save(productEntity);
    }

    public ProductEntity updateProduct(Long id, ProductUpdateDTO productUpdateDTO){
        ProductEntity existing = productRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        
        modelMapper.map(productUpdateDTO, existing);

        return productRepo.save(existing);
    }

    public void deleteProduct(Long id){
        ProductEntity product = productRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Product does not exist, recheck id"));

        productRepo.delete(product);
        

    }
}
