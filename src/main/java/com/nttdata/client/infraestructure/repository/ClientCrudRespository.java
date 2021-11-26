package com.nttdata.client.infraestructure.repository;

import com.nttdata.client.application.model.ClientRepository;
import com.nttdata.client.domain.Client;
import com.nttdata.client.infraestructure.model.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ClientCrudRespository implements ClientRepository {

    @Autowired
    IClientCrudRepository repository;

    @Override
    public Mono<Client> create(Client client) {
        return repository.save(mapClientToClientDao(client))
                .map(this::mapClientDaoToClient);
    }

    @Override
    public Mono<Client> update(String id, Client client) {
        return repository.findById(id)
                .flatMap(p-> create(mapClientDaoToClient(p,client)));
    }

    @Override
    public Mono<ClientDao> delete(String id) {
        return repository.findById(id)
                .flatMap( p -> repository.deleteById(p.getClientId()).thenReturn(p));
    }

    @Override
    public Mono<Client> findById(String id) {
        return repository.findById(id)
                .map(this::mapClientDaoToClient);
    }

    @Override
    public Flux<Client> findAll() {
        return repository.findAll()
                .map(this::mapClientDaoToClient);
    }

    private ClientDao mapClientToClientDao (Client client){
        ClientDao clientDao = new ClientDao();
        clientDao.setClientId(client.getClientId());
        clientDao.setClientName(client.getClientName());
        clientDao.setClientStatus(client.getClientStatus());
        clientDao.setClientDNI(client.getClientDNI());
        clientDao.setClientEmail(client.getClientEmail());
        clientDao.setClientType(client.getClientType());
        return clientDao;
    }

    private Client mapClientDaoToClient (ClientDao clientDao){
        Client client = new Client();
        client.setClientId(clientDao.getClientId());
        client.setClientName(clientDao.getClientName());
        client.setClientStatus(clientDao.getClientStatus());
        client.setClientDNI(clientDao.getClientDNI());
        client.setClientEmail(clientDao.getClientEmail());
        client.setClientType(clientDao.getClientType());
        return client;
    }

    private Client mapClientDaoToClient (ClientDao clientDao, Client client){
        client.setClientId(clientDao.getClientId());
        return client;
    }
}
