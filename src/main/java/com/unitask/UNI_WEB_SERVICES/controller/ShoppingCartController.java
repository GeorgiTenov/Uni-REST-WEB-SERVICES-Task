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
import com.unitask.UNI_WEB_SERVICES.model.ShoppingCart;
import com.unitask.UNI_WEB_SERVICES.service.ShoppingCartService;

import jakarta.annotation.Resource;

@RestController
public class ShoppingCartController implements MyService<ShoppingCart> {
    @Resource
    private ShoppingCartService shoppingCartService;
    @Override
    @GetMapping("/shopping-carts/")
    public List<ShoppingCart> findAll() {
        return shoppingCartService.findAll();
    }

    @Override
    @GetMapping("/shopping-carts/{id}")
    public ShoppingCart findById(@PathVariable("id") Long id) {
        return shoppingCartService.findById(id);
    }

    @Override
    @PostMapping("/shopping-carts/")
    public void create(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartService.create(shoppingCart);
    }

    @Override
    @DeleteMapping("/shopping-carts/{id}")
    public void delete(@PathVariable("id") Long id) {
        shoppingCartService.delete(id);
    }

    @Override
    @PutMapping("/shopping-carts/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody ShoppingCart shoppingCart) {
        shoppingCartService.update(id,shoppingCart);
    }

    @GetMapping("/shopping-carts/order/{orderId}")
    public List<ShoppingCart> findShoppingCartsByOrderId(@PathVariable("orderId") Long orderId) {
        return shoppingCartService.findShoppingCartsByOrderId(orderId);
    }
}
