package com.rossi.controlejogos.model;

import java.io.Serializable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "jogo")
public class Jogo implements Serializable {
    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;
    @DatabaseField(canBeNull = false)
    private String nome;
    @DatabaseField(canBeNull = false)
    private String ano;
    @DatabaseField(canBeNull = false)
    private String plataforma;
    @DatabaseField(canBeNull = false)
    private String genero;
    @DatabaseField(canBeNull = false)
    private String produtora;

    public Jogo() {
    }

    public Jogo(String nome, String ano, String plataforma, String genero, String produtora) {
        this.nome = nome;
        this.ano = ano;
        this.plataforma = plataforma;
        this.genero = genero;
        this.produtora = produtora;
    }

    public Jogo(Integer id, String nome, String ano, String plataforma, String genero, String produtora) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.plataforma = plataforma;
        this.genero = genero;
        this.produtora = produtora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    @Override
    public String toString(){return "Nome " + ":" + nome + "," +" " + "Ano " + ": " + ano + "," + "\n"+ "Plataforma" + ": " + plataforma + ","+ " " + "Genero " + ": " + genero + "," + " " + "Produtora "
            + ": " + produtora;}
}
