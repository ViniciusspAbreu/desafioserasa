package com.desafio.DesafioSerasaExperian.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Afinidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    private String regiao;
    @ElementCollection
    private List<String> estados;

    public Afinidade() {

    }

    public Afinidade(Integer id, String regiao, List estados) {
        this.id = id;
        this.regiao = regiao;
        this.estados = estados;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public List getEstados() {
        return estados;
    }

    public void setEstados(List estados) {
        this.estados = estados;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
