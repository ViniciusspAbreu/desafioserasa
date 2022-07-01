package com.desafio.DesafioSerasaExperian.services;

import com.desafio.DesafioSerasaExperian.domain.Score;
import com.desafio.DesafioSerasaExperian.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public Score insert(Score score){
        return scoreRepository.save(score);
    }

}
