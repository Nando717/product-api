package com.product.api.models;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCTS")
@Data
public class ProductModel implements Serializable {

    // numero de controle de versao de cada classe que forem serealizadas.
    private static final long serioVersionUID = 1L;


    @Id
    //para que o id seja gerado automaticamente
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduct;
    private String name;
    private BigDecimal valor;

}
