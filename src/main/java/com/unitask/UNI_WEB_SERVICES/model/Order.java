package com.unitask.UNI_WEB_SERVICES.model;

import java.time.LocalDateTime;

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
        name = "order_seq",
        sequenceName = "order_seq",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @Column(name = "id",
            nullable = false)
    private Long id;
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
}
