package com.desafio.DesafioSerasaExperian.services;

import com.desafio.DesafioSerasaExperian.domain.Pessoa;
import com.desafio.DesafioSerasaExperian.dto.PessoaDTO;
import com.desafio.DesafioSerasaExperian.repositories.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class PessoaServiceTest {

    public static final Date DATA_INCLUSAO = new Date();
    public static final Integer ID = 1;
    public static final String TESTE_NOME = "testeNome";
    public static final String TELEFONE = "983967183";
    public static final Integer IDADE = 18;
    public static final String SÃO_PAULO = "São Paulo";
    public static final String SP = "SP";
    public static final Integer SCORE = 900;
    public static final String SUL = "sul";
    public static final String ALAGOAS = "Alagoas";
    public static final String AL = "AL";
    public static final String SCORE_DESCRICAO = "300";
    public static final List<String> ESTADOS = Arrays.asList("RS", "PR", "SC");

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    private Pessoa pessoa;

    private PessoaDTO pessoaDTO;

    private Optional<Pessoa> optionalPessoa;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPessoa();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(pessoaRepository.findById(anyInt())).thenReturn(optionalPessoa);

        Pessoa response = pessoaService.find(ID);

        assertNotNull(response);

        assertEquals(Pessoa.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(DATA_INCLUSAO, response.getDataInclusao());
        assertEquals(TESTE_NOME, response.getNome());
        assertEquals(TELEFONE, response.getTelefone());
        assertEquals(IDADE, response.getIdade());
        assertEquals(SÃO_PAULO, response.getCidade());
        assertEquals(SP, response.getEstado());
        assertEquals(SCORE, response.getScore());
        assertEquals(SUL, response.getRegiao());
    }

    @Test
    void insert() {
    }

    @Test
    void findAll() {
    }

    private void startPessoa() {
        pessoa = new Pessoa(ID, DATA_INCLUSAO, TESTE_NOME, TELEFONE, IDADE, SÃO_PAULO, SP, SCORE, SUL);
        pessoaDTO = new PessoaDTO(TESTE_NOME, ALAGOAS, AL, SCORE_DESCRICAO, ESTADOS);
        optionalPessoa = Optional.of(new Pessoa(ID, DATA_INCLUSAO, TESTE_NOME, TELEFONE, IDADE, SÃO_PAULO, SP, SCORE, SUL));
    }
}