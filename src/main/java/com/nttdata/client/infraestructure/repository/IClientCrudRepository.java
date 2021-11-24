package com.nttdata.client.infraestructure.repository;

import com.nttdata.client.infraestructure.model.dao.ClientDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IClientCrudRepository extends ReactiveCrudRepository<ClientDao, String> {

}
