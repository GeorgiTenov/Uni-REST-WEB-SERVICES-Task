package com.unitask.UNI_WEB_SERVICES.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(
        name = "product_seq",
        sequenceName = "product_seq",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @Column(name = "id",
            nullable = false)
    private Long id;
    @Column(name = "shopping_cart_id")
    private Long shoppingCartId;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
}
