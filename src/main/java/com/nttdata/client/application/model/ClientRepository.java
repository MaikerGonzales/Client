package com.nttdata.client.application.model;

import com.nttdata.client.domain.Client;
import com.nttdata.client.infraestructure.model.dao.ClientDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientRepository {

    public Mono<Client> create(Client client);
    public Mono<Client> update(String id, Client client);
    public Mono<ClientDao> delete(String id);
    public Mono<Client> findById(String id);
    public Flux<Client> findAll();

}
