package com.desafio.DesafioSerasaExperian.services;

import com.desafio.DesafioSerasaExperian.domain.Afinidade;
import com.desafio.DesafioSerasaExperian.repositories.AfinidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AfinidadeService {

    @Autowired
    private AfinidadeRepository afinidadeRepository;

    public Afinidade insert(Afinidade afinidade){
        return afinidadeRepository.save(afinidade);
    }

}
