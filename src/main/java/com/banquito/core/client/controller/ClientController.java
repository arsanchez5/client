package com.banquito.core.client.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.client.model.Client;
import com.banquito.core.client.service.CommonClientService;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    private final CommonClientService service;

    public ClientController(CommonClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Client>> findClient() {
        try {
            return ResponseEntity.ok(this.service.obtainAllClients());
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }
}
