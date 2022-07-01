package com.desafio.DesafioSerasaExperian.services;

import com.desafio.DesafioSerasaExperian.domain.Score;
import com.desafio.DesafioSerasaExperian.repositories.ScoreRepository;
import com.desafio.DesafioSerasaExperian.services.enums.ScoreEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ScoreServiceTest {

    public static final Integer ID = 1;
    public static final int INICIAL = 100;
    public static final int FINAL_SCORE = 200;
    public static final String SCORE_DESCRICAO = ScoreEnum.ACEITAVEL.toString();

    @InjectMocks
    private ScoreService scoreService;

    @Mock
    private ScoreRepository scoreRepository;

    private Score score;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startScore();
    }

    @Test
    void whenCreateThenReturnSuccess() {
        when(scoreRepository.save(any())).thenReturn(score);

        Score response = scoreService.insert(score);

        assertNotNull(response);
        assertEquals(Score.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(SCORE_DESCRICAO, response.getScoreDescricao());
        assertEquals(INICIAL, response.getInicial());
        assertEquals(FINAL_SCORE, response.getFinalScore());
    }

    private void startScore() {
        score = new Score(ID, SCORE_DESCRICAO, INICIAL, FINAL_SCORE);
    }
}