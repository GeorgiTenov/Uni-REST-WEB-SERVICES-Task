package com.unitask.UNI_WEB_SERVICES.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long id;
    //This is related to Client
    private Long clientId;
    private LocalDateTime createdOn;
}
