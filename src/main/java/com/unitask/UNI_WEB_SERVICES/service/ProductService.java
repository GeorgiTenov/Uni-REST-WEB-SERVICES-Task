package com.unitask.UNI_WEB_SERVICES.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitask.UNI_WEB_SERVICES.interfaces.Service;
import com.unitask.UNI_WEB_SERVICES.model.Product;

@RestController
public class ProductService implements Service<Product> {
    private final List<Product> products = new ArrayList<>();

    @Override
    @GetMapping("/products/")
    public List<Product> findAll() {
        return products;
    }

    @Override
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return products.stream()
                .filter(product -> product.getId()
                        .equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    @PostMapping("/products/")
    public void create(@RequestBody Product entity) {
        products.add(entity);
    }

    @Override
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") Long id) {
        products.removeIf(product -> product.getId()
                .equals(id));
    }

    @Override
    @PutMapping("/products/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Product entity) {
        Optional<Product> productOptional = products.stream()
                .filter(product -> product.getId()
                        .equals(entity.getId()))
                .findFirst();
        productOptional.ifPresent(product -> product.setShoppingCartId(entity.getShoppingCartId()));
    }

    @GetMapping("/products/shopping-cart/{shoppingCartId}")
    public List<Product> findProductsByShoppingCartId(@PathVariable("shoppingCartId") Long shoppingCartId) {
        return products.stream()
                .filter(product -> product.getShoppingCartId()
                        .equals(shoppingCartId))
                .toList();
    }
}
