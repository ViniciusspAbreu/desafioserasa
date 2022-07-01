package com.desafio.DesafioSerasaExperian.dto;

import com.desafio.DesafioSerasaExperian.domain.Pessoa;

import java.io.Serializable;
import java.util.List;

public class PessoaDTO implements Serializable {

    private String nome;

    private String	cidade;

    private String	estado;

    private String	scoreDescricao;

    private List estados;

    public PessoaDTO(){
    }

    public PessoaDTO(String nome, String cidade, String estado, String scoreDescricao, List estados) {
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.scoreDescricao = scoreDescricao;
        this.estados = estados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getScoreDescricao() {
        return scoreDescricao;
    }

    public void setScoreDescricao(String scoreDescricao) {
        this.scoreDescricao = scoreDescricao;
    }

    public List getEstados() {
        return estados;
    }

    public void setEstados(List estados) {
        this.estados = estados;
    }
}
