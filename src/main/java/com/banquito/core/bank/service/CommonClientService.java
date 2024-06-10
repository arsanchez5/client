package com.banquito.core.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.core.bank.model.Client;
import com.banquito.core.bank.model.ClientPhone;
import com.banquito.core.bank.model.ClientAddress;
import com.banquito.core.bank.model.Segment;
import com.banquito.core.bank.repository.ClientAddressRepository;
import com.banquito.core.bank.repository.ClientPhoneRepository;
import com.banquito.core.bank.repository.ClientRepository;
import com.banquito.core.bank.repository.SegmentRepository;

@Service
public class CommonClientService {

    private ClientRepository clientRepository;
    private ClientPhoneRepository clientPhoneRepository;
    private ClientAddressRepository clientAddressRepository;
    private SegmentRepository segmentRepository;    
    
    public CommonClientService(ClientRepository clientRepository, ClientPhoneRepository clientPhoneRepository,
            ClientAddressRepository clientAddressRepository, SegmentRepository segmentRepository) {
        this.clientRepository = clientRepository;
        this.clientPhoneRepository = clientPhoneRepository;
        this.clientAddressRepository = clientAddressRepository;
        this.segmentRepository = segmentRepository;
    }

    public List<Client> obtainAllClients(){
        return this.clientRepository.findAll();      
    }

    public Client obtainClient(Integer id){
        Optional<Client> clientOpt = this.clientRepository.findById(id);
        if(clientOpt.isPresent()){
            return clientOpt.get();
        } else {
            throw new RuntimeException("No existe el cliente con id: "+id);
        }
    }

    public List<ClientPhone> obtainAllClientPhones(){
        return this.clientPhoneRepository.findAll();
    }

    public ClientPhone obtainClientPhone(Integer id){
        Optional<ClientPhone> clientPhoneOpt = this.clientPhoneRepository.findById(id);
        if(clientPhoneOpt.isPresent()){
            return clientPhoneOpt.get();
        } else {
            throw new RuntimeException("No existe el telefono con id: "+id);
        }
    }

    public List<ClientAddress> obtainAllClientAddresses(){
        return this.clientAddressRepository.findAll();
    }

    public ClientAddress obtainClientAddress(Integer id){
        Optional<ClientAddress> clientAddressOpt = this.clientAddressRepository.findById(id);
        if(clientAddressOpt.isPresent()){
            return clientAddressOpt.get();
        } else {
            throw new RuntimeException("No existe la direccion con id: "+id);
        }
    }

    public List<Segment> obtainAllSegments(){
        return this.segmentRepository.findAll();
    }

    public Segment obtainSegment(String id){
        Optional<Segment> segmentOpt = this.segmentRepository.findById(id);
        if(segmentOpt.isPresent()){
            return segmentOpt.get();
        } else {
            throw new RuntimeException("No existe el segmento con id: "+id);
        }
    }

}
