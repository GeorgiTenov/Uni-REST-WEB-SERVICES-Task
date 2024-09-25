package com.unitask.UNI_WEB_SERVICES.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitask.UNI_WEB_SERVICES.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
