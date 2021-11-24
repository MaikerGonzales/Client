package com.nttdata.client.infraestructure.rest;

import com.nttdata.client.application.ClientOperations;
import com.nttdata.client.domain.Client;
import com.nttdata.client.infraestructure.model.dao.ClientDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientOperations clientOperations;

    @GetMapping
    public Flux<Client> getAll(){
        return clientOperations.findAll();
    }

    @GetMapping("/{clientId}")
    public Mono<Client> getById(@PathVariable String clientId){
        return clientOperations.findById(clientId);
    }

    @PostMapping
    public Mono<Client> post(@RequestBody Client client){
        return clientOperations.create(client);
    }

    @PutMapping("/{clientId}")
    public Mono<Client> put(@PathVariable String clientId, @RequestBody Client client){
        return clientOperations.update(clientId,client);
    }

    @DeleteMapping("/{id}")
    public  Mono<ClientDao> delete(@PathVariable String id){
        return clientOperations.delete(id);
    }


}
