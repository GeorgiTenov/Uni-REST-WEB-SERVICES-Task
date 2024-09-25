package com.unitask.UNI_WEB_SERVICES.model;

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
        name = "shopping_cart_seq",
        sequenceName = "shopping_cart_seq",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shopping_cart_seq")
    @Column(name = "id",
            nullable = false)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
}
