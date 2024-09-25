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
        name = "client_seq",
        sequenceName = "client_seq",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @Column(name = "id",
            nullable = false)
    private Long id;
    @Column(name = "Username")
    private String username;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
}
