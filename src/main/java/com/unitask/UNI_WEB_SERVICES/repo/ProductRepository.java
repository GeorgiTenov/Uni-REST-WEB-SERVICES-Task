package com.unitask.UNI_WEB_SERVICES.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitask.UNI_WEB_SERVICES.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
