package com.example.resttemplaterastreamento.controller;

import com.example.resttemplaterastreamento.model.Clientes;
import com.example.resttemplaterastreamento.service.RastreamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rastreamento")
public class RastreamentoController {

    @Autowired
    private RastreamentoService service;

    @GetMapping()
    public Clientes[] get() {return service.getClientes();}

    @GetMapping("/{id}")
    public Clientes get(@PathVariable("id") UUID id) {return service.getClientesById(id);}

    @PostMapping
    public ResponseEntity<Clientes> post(@RequestBody Clientes clientes){
        Clientes c = service.insert(clientes);
        return  new ResponseEntity(c, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> put(@PathVariable("id") UUID id, @RequestBody Clientes clientes){
        Clientes clientesDto = new Clientes();
        clientesDto.setBairro(clientes.getBairro());
        clientesDto.setCidade(clientes.getCidade());
        clientesDto.setNome(clientes.getNome());
        clientesDto.setNumero_logradouro(clientes.getNumero_logradouro());
        clientesDto.setRua(clientes.getRua());
        clientesDto.setTelefone(clientes.getTelefone());
        Clientes c = service.update(clientes,id);

        return new ResponseEntity<>(c, HttpStatus.ALREADY_REPORTED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) { service.delete(id);}




}
