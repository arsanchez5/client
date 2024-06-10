package com.banquito.core.bank.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.bank.model.Client;
import com.banquito.core.bank.service.CommonClientService;

@RestController
public class ClientController {

    private final CommonClientService service;

    public ClientController(CommonClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Client>> findClient(){
        try {
            return ResponseEntity.ok(this.service.obtainAllClients());
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }
}
