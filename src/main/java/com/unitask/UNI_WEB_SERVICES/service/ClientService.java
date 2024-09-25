package com.unitask.UNI_WEB_SERVICES.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unitask.UNI_WEB_SERVICES.interfaces.MyService;
import com.unitask.UNI_WEB_SERVICES.model.Client;
import com.unitask.UNI_WEB_SERVICES.repo.ClientRepository;

import jakarta.annotation.Resource;

@Service
public class ClientService implements MyService<Client> {
    @Resource
    private ClientRepository repository;

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public void create(Client entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, Client entity) {
        Optional<Client> optionalClient = repository.findById(id);
        optionalClient.ifPresent(client -> {
            client.setEmail(entity.getEmail());
            client.setUsername(entity.getUsername());
            client.setPhone(entity.getPhone());
            repository.save(client);
        });
    }
}
