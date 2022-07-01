package com.desafio.DesafioSerasaExperian.resources;

import com.desafio.DesafioSerasaExperian.domain.Score;
import com.desafio.DesafioSerasaExperian.services.ScoreService;
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
@RequestMapping(value="/score")
public class ScoreResource {

    @Autowired
    private ScoreService scoreService;

    @ApiOperation(value = "Insere score")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Score score){
        score = scoreService.insert(score);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(score.getClass()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
