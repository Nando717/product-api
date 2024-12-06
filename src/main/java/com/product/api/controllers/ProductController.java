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
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value = "id") UUID id) {

        // Busca o produto no banco de dados. Retorna um Optional que pode conter ou não o produto.
        Optional<ProductModel> productO = productRepository.findById(id);

        // Verifica se o produto foi encontrado
        if(productO.isEmpty()){

            // Produto não encontrado, retorna 404 com a mensagem de erro.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado.");

        }

        // Produto encontrado, retorna 200 com o produto no corpo da resposta.
        return  ResponseEntity.status(HttpStatus.OK).body(productO.get());


    }


    @PutMapping("/products/{id}")

    public ResponseEntity<Object>upDateProduct(@PathVariable(value = "id") UUID id,
                                               @RequestBody @Valid ProductRecordDto productRecordDto){

        Optional<ProductModel> produtO = productRepository.findById(id);

        if(produtO.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado");
        }
        var productModel = produtO.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }


}
