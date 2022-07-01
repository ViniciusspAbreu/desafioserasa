package com.desafio.DesafioSerasaExperian.repositories;

import com.desafio.DesafioSerasaExperian.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
