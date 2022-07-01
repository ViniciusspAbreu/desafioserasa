package com.desafio.DesafioSerasaExperian.services;

import com.desafio.DesafioSerasaExperian.domain.Afinidade;
import com.desafio.DesafioSerasaExperian.domain.Score;
import com.desafio.DesafioSerasaExperian.repositories.AfinidadeRepository;
import com.desafio.DesafioSerasaExperian.repositories.ScoreRepository;
import com.desafio.DesafioSerasaExperian.services.enums.ScoreEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class AfinidadeServiceTest {

    public static final Integer ID = 1;

    public static final List<String> ESTADOS = Arrays.asList("RS", "PR", "SC");
    public static final String SUDESTE = "Sudeste";

    @InjectMocks
    private AfinidadeService afinidadeService;

    @Mock
    private AfinidadeRepository afinidadeRepository;

    private Afinidade afinidade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startAfinidade();
    }

    @Test
    void whenCreateThenReturnSuccess() {
        when(afinidadeRepository.save(any())).thenReturn(afinidade);

        Afinidade response = afinidadeService.insert(afinidade);

        assertNotNull(response);
        assertEquals(Afinidade.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(SUDESTE, response.getRegiao());
        assertEquals(ESTADOS, response.getEstados());
    }

    private void startAfinidade() {
        afinidade = new Afinidade(ID, SUDESTE, ESTADOS);
    }
}