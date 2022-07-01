package com.desafio.DesafioSerasaExperian.services;

import com.desafio.DesafioSerasaExperian.domain.Pessoa;
import com.desafio.DesafioSerasaExperian.dto.PessoaDTO;
import com.desafio.DesafioSerasaExperian.services.enums.ScoreEnum;
import com.desafio.DesafioSerasaExperian.repositories.PessoaRepository;
import com.desafio.DesafioSerasaExperian.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa find(Integer id) {
        var obj = pessoaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
            + ", Tipo: " + Pessoa.class.getName()));
        }

    public Pessoa insert(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public ArrayList<PessoaDTO> findAll(){
        var pessoas = pessoaRepository.findAll();
        return verificaScore(pessoas);
    }

    private ArrayList<PessoaDTO> verificaScore(List<Pessoa> pessoas){
        var pessoaDTO = new ArrayList<PessoaDTO>();
        for (int i = 0; i < pessoas.size(); i++) {
            if(pessoas.get(i).getScore() <= 200){
                pessoaDTO.add(new PessoaDTO(pessoas.get(i).getNome(), pessoas.get(i).getCidade(),pessoas.get(i).getEstado(),
                        ScoreEnum.INSUFICIENTE.toString(), verificaEstados(pessoas.get(i).getRegiao())));
            } else if (pessoas.get(i).getScore() > 200 && pessoas.get(i).getScore() <= 500) {
                pessoaDTO.add(new PessoaDTO(pessoas.get(i).getNome(), pessoas.get(i).getCidade(),pessoas.get(i).getEstado(),
                        ScoreEnum.INACEITAVEL.toString(), verificaEstados(pessoas.get(i).getRegiao())));
            } else if (pessoas.get(i).getScore() > 500 && pessoas.get(i).getScore() <= 700) {
                pessoaDTO.add(new PessoaDTO(pessoas.get(i).getNome(), pessoas.get(i).getCidade(),pessoas.get(i).getEstado(),
                        ScoreEnum.ACEITAVEL.toString(), verificaEstados(pessoas.get(i).getRegiao())));
            } else if (pessoas.get(i).getScore() > 700) {
                pessoaDTO.add(new PessoaDTO(pessoas.get(i).getNome(), pessoas.get(i).getCidade(),pessoas.get(i).getEstado(),
                        ScoreEnum.RECOMENDAVEL.toString(), verificaEstados(pessoas.get(i).getRegiao())));
            }
        }
        return pessoaDTO;
    }

    private List verificaEstados(String regiao){
        switch (regiao){
            case "norte":
                var siglasListNorte = Arrays.asList("RR", "AP", "PA", "AC", "RO", "AM", "TO");
                return siglasListNorte;
            case "sudeste":
                var siglasListsiglasSudeste = Arrays.asList("MG", "ES", "SP", "RJ");
                return siglasListsiglasSudeste;
            case "sul":
                var siglasListSul = Arrays.asList("RS", "PR", "SC");
                return siglasListSul;
        }
        return Arrays.asList("A regiao digitada é invalida");
    }
}
