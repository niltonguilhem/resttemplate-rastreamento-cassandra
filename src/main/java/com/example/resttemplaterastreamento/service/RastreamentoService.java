package com.example.resttemplaterastreamento.service;

import com.example.resttemplaterastreamento.config.RestTemplateIntegration;
import com.example.resttemplaterastreamento.model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RastreamentoService {

    @Autowired
    private RestTemplateIntegration restTemplate;

    public Clientes[] getClientes(){
        Clientes[] clientes = restTemplate.getForObject("http://localhost:8080/api/v1/rastreamento",Clientes[].class);
        return clientes;
    }

    public Clientes getClientesById(UUID id){
        Clientes clientes = restTemplate.getForObject("http://localhost:8080/api/v1/rastreamento/"+id,Clientes.class);
        return clientes;
    }

    public Clientes insert(Clientes clientes){
        ResponseEntity<Clientes> clientesEntity =
                restTemplate.postForEntity("http://localhost:8080/api/v1/rastreamento",clientes,Clientes.class);
        return  clientesEntity.getBody();
    }

    public Clientes update(Clientes clientes, UUID id) {
        HttpEntity requestEntity = new HttpEntity<>(clientes);
        ResponseEntity<Clientes> clientesEntity =
                restTemplate.exchange("http://localhost:8080/api/v1/rastreamento/"+id, HttpMethod.PUT,requestEntity,
                        Clientes.class);
        return clientesEntity.getBody();

    }

    public void delete(UUID id) {
        ResponseEntity<Clientes> clientesEntity = restTemplate.exchange("http://localhost:8080/api/v1/rastreamento/"+id
                ,HttpMethod.DELETE, null, Clientes      .class);
    }
}
