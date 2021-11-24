package com.nttdata.client.application;

import com.nttdata.client.domain.Client;
import com.nttdata.client.infraestructure.model.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientOperationsImpl implements ClientOperations {

    @Autowired
    ClientRespository repository;

    @Override
    public Mono<Client> create(Client client) {
        return repository.create(client);
    }

    @Override
    public Mono<Client> update(String id, Client client) {
        return repository.update(id, client);
    }

    @Override
    public Mono<ClientDao> delete(String id) {
        return repository.delete(id);
    }

    @Override
    public Mono<Client> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Client> findAll() {
        return repository.findAll();
    }
}
