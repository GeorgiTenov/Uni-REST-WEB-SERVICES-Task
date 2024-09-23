package com.unitask.UNI_WEB_SERVICES.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    //This is related to Shopping cart
    private Long shoppingCartId;
}
