package com.desafio.DesafioSerasaExperian.resources;

import com.desafio.DesafioSerasaExperian.domain.Cliente;
import com.desafio.DesafioSerasaExperian.domain.Pessoa;
import com.desafio.DesafioSerasaExperian.dto.PessoaDTO;
import com.desafio.DesafioSerasaExperian.services.ClienteService;
import com.desafio.DesafioSerasaExperian.services.PessoaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @ApiOperation(value = "Busca Cliente")
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find(@PathVariable Integer id){
        var cliente = service.find(id);
        return ResponseEntity.ok().body(cliente);
    }
}
