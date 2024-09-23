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
import com.unitask.UNI_WEB_SERVICES.model.Client;

@RestController
public class ClientService implements Service<Client> {
    private final List<Client> clients = new ArrayList<>();

    @Override
    @GetMapping("/clients/")
    public List<Client> findAll() {
        return clients;
    }

    @Override
    @GetMapping("/clients/{id}")
    public Client findById(@PathVariable("id") Long id) {
        return clients.stream()
                .filter(client -> client.getId()
                        .equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    @PostMapping("/clients/")
    public void create(@RequestBody Client entity) {
        clients.add(entity);
    }

    @Override
    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable("id") Long id) {
        clients.removeIf(client -> client.getId()
                .equals(id));
    }

    @Override
    @PutMapping("/clients/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Client entity) {
        Optional<Client> optionalClient = clients.stream()
                .filter(client -> client.getId()
                        .equals(id))
                .findFirst();
        optionalClient.ifPresent(client -> {
            client.setUsername(entity.getUsername());
            client.setPhone(entity.getPhone());
            client.setEmail(entity.getEmail());
        });
    }
}
