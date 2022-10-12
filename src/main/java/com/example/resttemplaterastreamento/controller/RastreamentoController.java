package com.example.resttemplaterastreamento.controller;

import com.example.resttemplaterastreamento.model.Clientes;
import com.example.resttemplaterastreamento.model.ClientesRequest;
import com.example.resttemplaterastreamento.model.ClientesResponse;
import com.example.resttemplaterastreamento.service.RastreamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/rastreamento")
public class RastreamentoController {

    private static final Logger logger = LoggerFactory.getLogger(RastreamentoController.class);

    @Autowired
    private RastreamentoService service;

    @GetMapping()
    public ResponseEntity<List<ClientesResponse>> getAllClientes() {
        logger.info("m=getAllClientes - status=start");
        List<Clientes> clientesList = service.findAllClientes();
        List<ClientesResponse> clientesResponseList = clientesList.stream().map(clientes -> new ClientesResponse()
                .withBuilderId(clientes.getId())
                .withBuilderBairro(clientes.getBairro())
                .withBuilderCidade(clientes.getCidade())
                .withBuilderNome(clientes.getNome())
                .withBuilderRua(clientes.getRua())
                .withBuilderNumero_logradouro(clientes.getNumero_logradouro())
                .withBuilderTelefone(clientes.getTelefone())).collect(Collectors.toList());
        logger.info("m=getAllClientes - status=finish");
        return new ResponseEntity<>(clientesResponseList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientesResponse> getIdClientes(@PathVariable("id") UUID id) {
        logger.info("m=getIdClientes - status=start " + id);
        Clientes clientes = service.getClientesById(id);
        ClientesResponse response = new ClientesResponse()
                .withBuilderId(clientes.getId())
                .withBuilderBairro(clientes.getBairro())
                .withBuilderCidade(clientes.getCidade())
                .withBuilderNome(clientes.getNome())
                .withBuilderRua(clientes.getRua())
                .withBuilderNumero_logradouro(clientes.getNumero_logradouro())
                .withBuilderTelefone(clientes.getTelefone());
        logger.info("m=getIdClientes - status=finish " + id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ClientesResponse> postClientes(@RequestBody ClientesRequest clientesRequest,
                                                         @RequestHeader (value = "Partner") String Partner){
        ResponseEntity<ClientesResponse> result;
        logger.info("m=postClientes - status=start " + Partner);
        Clientes clientes = service.save(new Clientes()
                .withBuilderBairro(clientesRequest.getBairro())
                .withBuilderCidade(clientesRequest.getCidade())
                .withBuilderNome(clientesRequest.getNome())
                .withBuilderRua(clientesRequest.getRua())
                .withBuilderNumero_logradouro(clientesRequest.getNumero_logradouro())
                .withBuilderTelefone(clientesRequest.getTelefone()));

        ClientesResponse response = new ClientesResponse()
                .withBuilderId(clientes.getId())
                .withBuilderBairro(clientes.getBairro())
                .withBuilderCidade(clientes.getCidade())
                .withBuilderNome(clientes.getNome())
                .withBuilderRua(clientes.getRua())
                .withBuilderNumero_logradouro(clientes.getNumero_logradouro())
                .withBuilderTelefone(clientes.getTelefone());

        result = new ResponseEntity<>(response,HttpStatus.CREATED);
        logger.info("m=postClientes - status=finish " + Partner);
        return result;
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClientesResponse> putClientes(@PathVariable("id") UUID id,
                                                        @RequestBody ClientesRequest clientesRequest,
                                                        @RequestHeader (value = "Partner") String Partner){
        logger.info("m=putClientes - status=start " + id + " " + Partner);
        Clientes clientesUpdate = new Clientes()
                .withBuiderId(UUID.randomUUID())
                .withBuilderBairro(clientesRequest.getBairro())
                .withBuilderCidade(clientesRequest.getCidade())
                .withBuilderNome(clientesRequest.getNome())
                .withBuilderRua(clientesRequest.getRua())
                .withBuilderNumero_logradouro(clientesRequest.getNumero_logradouro())
                .withBuilderTelefone(clientesRequest.getTelefone());

        ClientesResponse response = new ClientesResponse()
                .withBuilderId(clientesUpdate.getId())
                .withBuilderBairro(clientesUpdate.getBairro())
                .withBuilderCidade(clientesUpdate.getCidade())
                .withBuilderNome(clientesUpdate.getNome())
                .withBuilderRua(clientesUpdate.getRua())
                .withBuilderNumero_logradouro(clientesUpdate.getNumero_logradouro())
                .withBuilderTelefone(clientesUpdate.getTelefone());

        Clientes clientesEntity = service.update(clientesUpdate,id);
        logger.info("m=putClientes - status=finish " + id + " " + Partner);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) { service.delete(id);}




}
