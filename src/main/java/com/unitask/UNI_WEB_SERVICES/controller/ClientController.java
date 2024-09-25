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
import com.unitask.UNI_WEB_SERVICES.model.Client;
import com.unitask.UNI_WEB_SERVICES.service.ClientService;

import jakarta.annotation.Resource;

@RestController
public class ClientController implements MyService<Client> {
    @Resource
    private ClientService clientService;

    @Override
    @GetMapping("/clients/")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @Override
    @GetMapping("/clients/{id}")
    public Client findById(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }

    @Override
    @PostMapping("/clients/")
    public void create(@RequestBody Client entity) {
        clientService.create(entity);
    }

    @Override
    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable("id") Long id) {
        clientService.delete(id);
    }

    @Override
    @PutMapping("/clients/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Client entity) {
        clientService.update(id, entity);
    }
}
