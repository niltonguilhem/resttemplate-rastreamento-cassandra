package com.example.resttemplaterastreamento.model;

public class ClientesRequest{

        private String bairro;
        private String cidade;
        private String nome;
        private int numero_logradouro;
        private String rua;
        private int telefone;

        public ClientesRequest(){

        }

    public ClientesRequest(String bairro, String cidade, String nome, int numero_logradouro, String rua, int telefone) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.nome = nome;
        this.numero_logradouro = numero_logradouro;
        this.rua = rua;
        this.telefone = telefone;
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
    }


