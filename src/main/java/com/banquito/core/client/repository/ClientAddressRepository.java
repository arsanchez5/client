package com.banquito.core.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.core.client.model.ClientAddress;

public interface ClientAddressRepository extends JpaRepository<ClientAddress, Integer> {

}