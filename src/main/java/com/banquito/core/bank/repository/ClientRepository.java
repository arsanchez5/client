package com.banquito.core.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.core.bank.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByIdentification(String identification);

    Client findByEmail(String email);

}
