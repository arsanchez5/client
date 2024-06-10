package com.banquito.core.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.core.bank.model.ClientPhone;

public interface ClientPhoneRepository extends JpaRepository<ClientPhone, Integer> {

}
