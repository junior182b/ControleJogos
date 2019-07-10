package com.rossi.controlejogos.model;

public class Endereco {

    private String Cep;
    private String Logradouro;
    private String Bairro;
    private String Cidade;
    private String Estado;

    public Endereco(String cep, String logradouro, String bairro, String cidade, String estado) {
        Cep = cep;
        Logradouro = logradouro;
        Bairro = bairro;
        Cidade = cidade;
        Estado = estado;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String logradouro) {
        Logradouro = logradouro;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    @Override
    public String toString() {
        return "CEP: " + getCep()
                + "\nLogradouro: " + getLogradouro()
                + "\nBairro: " + getBairro()
                + "\nCidade: " + getCidade()
                + "\nEstado: " + getEstado();
    }
}


