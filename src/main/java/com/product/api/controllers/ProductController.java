package com.product.api.controllers;


import com.product.api.dto.ProductRecordDto;
import com.product.api.models.ProductModel;
import com.product.api.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")

public class ProductController {

    @Autowired
    ProductRepository productRepository;


    @PostMapping("/products")

    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));

    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAll() {
       return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

}
