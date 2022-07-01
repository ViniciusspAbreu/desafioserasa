package com.desafio.DesafioSerasaExperian.resources;

import com.desafio.DesafioSerasaExperian.domain.Pessoa;
import com.desafio.DesafioSerasaExperian.dto.PessoaDTO;
import com.desafio.DesafioSerasaExperian.services.PessoaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService service;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Busca pessoa por id")
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> find(@PathVariable Integer id){
        var pessoa = service.find(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Insere Pessoa")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Pessoa pessoa){
        pessoa = service.insert(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Busca pessoas")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PessoaDTO>> findAll(){
        var list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
