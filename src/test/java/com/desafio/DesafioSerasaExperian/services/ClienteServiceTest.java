package com.desafio.DesafioSerasaExperian.services;

import com.desafio.DesafioSerasaExperian.domain.Cliente;
import com.desafio.DesafioSerasaExperian.domain.Pessoa;
import com.desafio.DesafioSerasaExperian.dto.PessoaDTO;
import com.desafio.DesafioSerasaExperian.repositories.ClienteRepository;
import com.desafio.DesafioSerasaExperian.repositories.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClienteServiceTest {

    public static final Date DATA_INCLUSAO = new Date();
    public static final Integer ID = 1;
    public static final String TESTE_NOME = "testeNome";
    public static final String TESTE_TESTE_COM = "teste@teste.com";
    public static final String SENHA = "123";

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    private Cliente cliente;

    private Optional<Cliente> optionalPessoa;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCliente();
    }

    @Test
    void whenFindByIdThenReturnAnClienteInstance() {
        when(clienteRepository.findById(anyInt())).thenReturn(optionalPessoa);

        Cliente response = clienteService.find(ID);

        assertNotNull(response);

        assertEquals(Cliente.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(TESTE_NOME, response.getNome());
        assertEquals(TESTE_TESTE_COM, response.getEmail());
        assertEquals(SENHA, response.getSenha());
    }

    private void startCliente() {
        cliente = new Cliente(ID, TESTE_NOME, TESTE_TESTE_COM, SENHA);
        optionalPessoa = Optional.of(new Cliente(ID, TESTE_NOME, TESTE_TESTE_COM, SENHA));
    }
}