package com.desafio.DesafioSerasaExperian.resources;

import com.desafio.DesafioSerasaExperian.domain.Afinidade;
import com.desafio.DesafioSerasaExperian.services.AfinidadeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/afinidade")
public class AfinidadeResource {

    @Autowired
    private AfinidadeService afinidadeService;

    @ApiOperation(value = "Insere Afinidade")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Afinidade afinidade){
        afinidade = afinidadeService.insert(afinidade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(afinidade.getClass()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
