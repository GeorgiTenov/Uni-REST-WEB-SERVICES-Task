package com.unitask.UNI_WEB_SERVICES.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCart {
    private Long id;
    //This is related to Order
    private Long orderId;
}
