package com.unitask.UNI_WEB_SERVICES.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unitask.UNI_WEB_SERVICES.interfaces.MyService;
import com.unitask.UNI_WEB_SERVICES.model.ShoppingCart;
import com.unitask.UNI_WEB_SERVICES.repo.ShoppingCartRepository;

import jakarta.annotation.Resource;

@Service
public class ShoppingCartService implements MyService<ShoppingCart> {
    @Resource
    private ShoppingCartRepository repository;

    @Override
    public List<ShoppingCart> findAll() {
        return repository.findAll();
    }

    @Override
    public ShoppingCart findById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public void create(ShoppingCart entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, ShoppingCart entity) {
        repository.findById(id)
                .ifPresent(shoppingCart -> shoppingCart.setOrderId(entity.getOrderId()));
    }

    public List<ShoppingCart> findShoppingCartsByOrderId(Long orderId) {
        return repository.findAll()
                .stream()
                .filter(shoppingCart -> shoppingCart.getOrderId()
                        .equals(orderId))
                .toList();
    }
}
