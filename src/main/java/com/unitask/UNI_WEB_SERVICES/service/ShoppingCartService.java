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
import com.unitask.UNI_WEB_SERVICES.model.ShoppingCart;

@RestController
public class ShoppingCartService implements Service<ShoppingCart> {
    private final List<ShoppingCart> shoppingCarts = new ArrayList<>();

    @Override
    @GetMapping("/shopping-carts/")
    public List<ShoppingCart> findAll() {
        return shoppingCarts;
    }

    @Override
    @GetMapping("/shopping-carts/{id}")
    public ShoppingCart findById(@PathVariable("id") Long id) {
        return shoppingCarts.stream()
                .filter(shoppingCart -> shoppingCart.getId()
                        .equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    @PostMapping("/shopping-carts/")
    public void create(@RequestBody ShoppingCart shoppingCart) {
        shoppingCarts.add(shoppingCart);
    }

    @Override
    @DeleteMapping("/shopping-carts/{id}")
    public void delete(@PathVariable("id") Long id) {
        shoppingCarts.removeIf(shoppingCart -> shoppingCart.getId()
                .equals(id));
    }

    @Override
    @PutMapping("/shopping-carts/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody ShoppingCart shoppingCart) {
        Optional<ShoppingCart> existingCart = shoppingCarts.stream()
                .filter(cart -> cart.getId()
                        .equals(id))
                .findFirst();
        existingCart.ifPresent(cart -> cart.setOrderId(shoppingCart.getOrderId()));
    }

    @GetMapping("/shopping-carts/order/{orderId}")
    public List<ShoppingCart> findShoppingCartsByOrderId(@PathVariable("orderId") Long orderId) {
        return shoppingCarts.stream()
                .filter(shoppingCart -> shoppingCart.getOrderId()
                        .equals(orderId))
                .toList();
    }
}
