package com.unitask.UNI_WEB_SERVICES.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unitask.UNI_WEB_SERVICES.interfaces.MyService;
import com.unitask.UNI_WEB_SERVICES.model.Product;
import com.unitask.UNI_WEB_SERVICES.repo.ProductRepository;

import jakarta.annotation.Resource;

@Service
public class ProductService implements MyService<Product> {
    @Resource
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public void create(Product entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, Product entity) {
        Optional<Product> optionalProduct = repository.findById(id);
        optionalProduct.ifPresent(product -> {
            product.setShoppingCartId(entity.getShoppingCartId());
            product.setPrice(entity.getPrice());
            product.setDescription(entity.getDescription());
            repository.save(product);
        });
    }

    public List<Product> findProductsByShoppingCartId(Long shoppingCartId) {
        return repository.findAll()
                .stream()
                .filter(product -> product.getShoppingCartId()
                        .equals(shoppingCartId))
                .toList();
    }
}
