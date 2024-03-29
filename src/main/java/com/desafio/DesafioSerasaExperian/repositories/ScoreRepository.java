package com.desafio.DesafioSerasaExperian.repositories;

import com.desafio.DesafioSerasaExperian.domain.Afinidade;
import com.desafio.DesafioSerasaExperian.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
