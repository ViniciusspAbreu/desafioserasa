package com.desafio.DesafioSerasaExperian.repositories;

import com.desafio.DesafioSerasaExperian.domain.Afinidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfinidadeRepository extends JpaRepository<Afinidade, Integer> {

}
