package com.banquito.core.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.core.bank.model.ClientAddress;

public interface ClientAddressRepository extends JpaRepository<ClientAddress, Integer> {

}
