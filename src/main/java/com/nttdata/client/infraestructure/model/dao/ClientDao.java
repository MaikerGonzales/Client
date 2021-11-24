package com.nttdata.client.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("client")
public class ClientDao {

    @Id
    private String clientId;
    private String clientName;
    private String clientStatus;
    private String clientDNI;
    private String clientEmail;
    private String clientType;

}
