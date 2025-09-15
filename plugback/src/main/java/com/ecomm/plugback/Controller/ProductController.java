package com.ecomm.plugback.Controller;

import com.ecomm.plugback.Entities.Product.ProductEntity;
import com.ecomm.plugback.Services.ProductService;

import jakarta.validation.Valid;

import com.ecomm.plugback.DTO.ProductAddDTO;
import com.ecomm.plugback.DTO.ProductUpdateDTO;

import org.springframework.web.bind.annotation.*; 

import org.springframework.stereotype.Controller; 
import java.net.URI; 
import java.util.List; 

import org.springframework.data.domain.Page; 
import org.springframework.data.domain.PageRequest; 

import org.springframework.http.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/get")
    public Page<ProductEntity> getProducts(@RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size){
        return productService.getProducts(page, size);
    }

    @GetMapping("/{id}")
    public Optional<ProductEntity> getProductsById(@PathVariable Long id){
        return productService.getProductsById(id);
    }

    @PostMapping("/addProduct")
    public ProductEntity addProduct(@RequestBody ProductAddDTO productAddDTO){
        return productService.addProduct(productAddDTO);
    }

    @PutMapping("/updateProduct/{id}")
    public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDTO productUpdateDTO){
        return productService.updateProduct(id, productUpdateDTO);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

}
