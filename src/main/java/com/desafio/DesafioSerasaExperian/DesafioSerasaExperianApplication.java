package com.desafio.DesafioSerasaExperian;

import com.desafio.DesafioSerasaExperian.domain.Cliente;
import com.desafio.DesafioSerasaExperian.domain.Pessoa;
import com.desafio.DesafioSerasaExperian.repositories.ClienteRepository;
import com.desafio.DesafioSerasaExperian.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DesafioSerasaExperianApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioSerasaExperianApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var pessoa = new Pessoa(null, null, "Fulano de Tal", "99 99999-9999", 99, "São Paulo", "SP", 1000, "sudeste");
		var pessoa2 = new Pessoa(null, null, "Score menor", "99 99999-9999", 99, "Rio Grande do Sul", "RS", 200, "sul");

		pessoaRepository.saveAll(Arrays.asList(pessoa, pessoa2));

		Cliente teste = new Cliente(null, "teste", "teste@teste.com", bCryptPasswordEncoder.encode("123"));

		clienteRepository.saveAll(Arrays.asList(teste));
	}
}
