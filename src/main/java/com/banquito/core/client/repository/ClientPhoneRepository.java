package com.banquito.core.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.core.client.model.ClientPhone;

public interface ClientPhoneRepository extends JpaRepository<ClientPhone, Integer> {

}
