package com.desafio.DesafioSerasaExperian.domain;

import com.desafio.DesafioSerasaExperian.services.enums.ScoreEnum;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    private String scoreDescricao;
    private Integer	inicial;
    @JsonProperty("final")
    private Integer finalScore;

    public Score() {

    }

    public Score(Integer id, String scoreDescricao, Integer inicial, Integer finalScore) {
        this.id = id;
        this.scoreDescricao = scoreDescricao;
        this.inicial = inicial;
        this.finalScore = finalScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScoreDescricao() {
        return scoreDescricao;
    }

    public void setScoreDescricao(String scoreDescricao) {
        this.scoreDescricao = scoreDescricao;
    }

    public Integer getInicial() {
        return inicial;
    }

    public void setInicial(Integer inicial) {
        this.inicial = inicial;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return id.equals(score.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
