package com.unitask.UNI_WEB_SERVICES.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitask.UNI_WEB_SERVICES.model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
