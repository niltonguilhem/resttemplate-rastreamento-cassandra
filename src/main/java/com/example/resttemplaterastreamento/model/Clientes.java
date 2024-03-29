package com.example.resttemplaterastreamento.model;

import java.util.UUID;

public class Clientes {
    private UUID id;
    private String bairro;
    private String cidade;
    private String nome;
    private int numero_logradouro;
    private String rua;
    private int telefone;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero_logradouro() {
        return numero_logradouro;
    }

    public void setNumero_logradouro(int numero_logradouro) {
        this.numero_logradouro = numero_logradouro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Clientes withBuiderId(UUID id){
        setId(id);
        return this;
    }

    public Clientes withBuilderBairro(String bairro){
        setBairro(bairro);
        return this;
    }

    public Clientes withBuilderNome(String nome){
        setNome(nome);
        return this;
    }

    public Clientes withBuilderCidade(String cidade){
        setCidade(cidade);
        return this;
    }

    public Clientes withBuilderNumero_logradouro(int numero_logradouro){
        setNumero_logradouro(numero_logradouro);
        return this;
    }

    public Clientes withBuilderRua(String rua){
        setRua(rua);
        return this;
    }

    public Clientes withBuilderTelefone(int telefone){
        setTelefone(telefone);
        return this;
    }

}
