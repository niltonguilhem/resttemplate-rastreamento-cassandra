package com.example.resttemplaterastreamento.service;

import com.example.resttemplaterastreamento.config.RestTemplateIntegration;
import com.example.resttemplaterastreamento.model.Clientes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Service
public class RastreamentoService {

    private static final Logger logger = LoggerFactory.getLogger(RastreamentoService.class);

    @Autowired
    private RestTemplateIntegration restTemplate;

    @Value("${resttemplate-rastreamento.host}")
    private String host;

    @Value("${resttemplate-rastreamento.path}")
    private String path;

    public List<Clientes> findAllClientes() {
        logger.info("m=findAllEstoque - status=start");
        List<Clientes> clientes = restTemplate
                .exchange(host + path, HttpMethod.GET, null, new ParameterizedTypeReference<List<Clientes>>() {
                }).getBody();

        logger.info("m=findAllEstoque - status=finish");
        return clientes;
    }
    public Clientes getClientesById(UUID id) {
        logger.info("m=getClienteById - status=start " + id);
        URI uri = UriComponentsBuilder.fromHttpUrl(host + path + id)
                .build().toUri();
        Clientes clientes = restTemplate.exchange(uri.toString(), HttpMethod.GET, null, Clientes.class, id).getBody();
        logger.info("m=getClienteById - status=finish " + id);
        return clientes;
    }
    public Clientes save(Clientes clientes, String partner) {
        logger.info("m=save - status=start");
        HttpHeaders headers = new HttpHeaders();
        headers.add("partner", partner);
        HttpEntity<Clientes> entity = new HttpEntity<>(clientes,headers);
        URI uri = URI.create(host + path);
        ResponseEntity<Clientes> clientesEntity =
                restTemplate.exchange(uri,HttpMethod.POST,entity, Clientes.class);
        logger.info("m=save - status=finish");
        return clientesEntity.getBody();
    }
    public Clientes update(Clientes clientes, UUID id, String patner) {
        logger.info("m=update - status=start " + clientes.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.add("partner", patner);
        HttpEntity<Clientes> entity = new HttpEntity<>(clientes,headers);
        URI uri = URI.create(host + path + id);
        ResponseEntity<Clientes> clientesEntity =
                restTemplate.exchange(uri,HttpMethod.PUT,entity, Clientes.class);
        logger.info("m=update - status=finish " + clientes.getId());
        return clientesEntity.getBody();
    }
    public void delete(UUID id) {
        logger.info("m=delete - status=start");
        URI uri = URI.create(host + path + id);
        ResponseEntity<Clientes> clientesEntity = restTemplate.exchange(uri,HttpMethod.DELETE, null, Clientes.class);
        logger.info("m=delete - status=finish");
    }

}
