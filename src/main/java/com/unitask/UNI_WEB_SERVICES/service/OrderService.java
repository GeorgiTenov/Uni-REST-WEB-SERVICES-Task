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
import com.unitask.UNI_WEB_SERVICES.model.Order;

@RestController
public class OrderService implements Service<Order> {
    private final List<Order> orders = new ArrayList<>();

    @Override
    @GetMapping("/orders/")
    public List<Order> findAll() {
        return orders;
    }

    @Override
    @GetMapping("/orders/{id}")
    public Order findById(@PathVariable("id") Long id) {
        return orders.stream()
                .filter(order -> order.getId()
                        .equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    @PostMapping("/orders/")
    public void create(@RequestBody Order entity) {
        orders.add(entity);
    }

    @Override
    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable("id") Long id) {
        orders.removeIf(order -> order.getId()
                .equals(id));
    }

    @Override
    @PutMapping("/orders/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Order entity) {
        Optional<Order> optionalOrder = orders.stream()
                .filter(order -> order.getId()
                        .equals(id))
                .findFirst();
        optionalOrder.ifPresent(order -> {
            order.setClientId(entity.getClientId());
            order.setCreatedOn(entity.getCreatedOn());
        });
    }
}
