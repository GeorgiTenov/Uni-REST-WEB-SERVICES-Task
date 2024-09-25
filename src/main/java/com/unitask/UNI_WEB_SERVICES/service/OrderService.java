package com.unitask.UNI_WEB_SERVICES.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unitask.UNI_WEB_SERVICES.interfaces.MyService;
import com.unitask.UNI_WEB_SERVICES.model.Order;
import com.unitask.UNI_WEB_SERVICES.repo.OrderRepository;

import jakarta.annotation.Resource;

@Service
public class OrderService implements MyService<Order> {
    @Resource
    private OrderRepository repository;

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public void create(Order entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, Order entity) {
        repository.findById(id)
                .ifPresent(order -> {
                    order.setCreatedOn(entity.getCreatedOn());
                    order.setClient(entity.getClient());
                    repository.save(order);
                });
    }

    public List<Order> findOrdersByClientId(Long clientId) {
        return repository.findAll()
                .stream()
                .filter(order -> order.getClient().getId()
                        .equals(clientId))
                .toList();
    }
}
