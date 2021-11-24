package com.nttdata.client.domain;

import lombok.Data;

@Data
public class Client {

    private String clientId;
    private String clientName;
    private String clientStatus;
    private String clientDNI;
    private String clientEmail;
    private String clientType;

}
