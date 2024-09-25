package com.unitask.UNI_WEB_SERVICES.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitask.UNI_WEB_SERVICES.interfaces.MyService;
import com.unitask.UNI_WEB_SERVICES.model.Product;
import com.unitask.UNI_WEB_SERVICES.service.ProductService;

import jakarta.annotation.Resource;

@RestController
public class ProductController implements MyService<Product> {
    @Resource
    private ProductService productService;

    @Override
    @GetMapping("/products/")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @Override
    @PostMapping("/products/")
    public void create(@RequestBody Product entity) {
        productService.create(entity);
    }

    @Override
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }

    @Override
    @PutMapping("/products/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Product entity) {
        productService.update(id, entity);
    }

    @GetMapping("/products/shopping-cart/{shoppingCartId}")
    public List<Product> findProductsByShoppingCartId(@PathVariable("shoppingCartId") Long shoppingCartId) {
        return productService.findProductsByShoppingCartId(shoppingCartId);
    }
}
