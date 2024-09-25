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
import com.unitask.UNI_WEB_SERVICES.model.Order;
import com.unitask.UNI_WEB_SERVICES.service.OrderService;

import jakarta.annotation.Resource;

@RestController
public class OrderController implements MyService<Order> {
    @Resource
    private OrderService orderService;

    @Override
    @GetMapping("/orders/")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @Override
    @GetMapping("/orders/{id}")
    public Order findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

    @Override
    @PostMapping("/orders/")
    public void create(@RequestBody Order entity) {
        orderService.create(entity);
    }

    @Override
    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable("id") Long id) {
        orderService.delete(id);
    }

    @Override
    @PutMapping("/orders/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Order entity) {
        orderService.update(id, entity);
    }
}
