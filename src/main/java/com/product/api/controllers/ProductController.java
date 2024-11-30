package com.product.api.controllers;


import com.product.api.dto.ProductRecordDto;
import com.product.api.models.ProductModel;
import com.product.api.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProductController {

    @Autowired
    ProductRepository productRepository;



    @PostMapping("/products")

    public ResponseEntity<ProductModel>saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
    var productModel = new ProductModel();

    }

}
