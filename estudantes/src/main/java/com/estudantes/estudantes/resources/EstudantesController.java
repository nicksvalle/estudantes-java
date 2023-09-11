package com.estudantes.estudantes.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudantes.estudantes.dtos.EstudanteRequest;
import com.estudantes.estudantes.dtos.EstudanteResponse;
import com.estudantes.estudantes.entities.Estudantes;
import com.estudantes.estudantes.mappers.EstudantesMapper;
import com.estudantes.estudantes.services.EstudantesService;

@RestController
@RequestMapping("estudantes")
@CrossOrigin
public class EstudantesController {
    
    @Autowired
    private EstudantesService service;

    @GetMapping
    public ResponseEntity<List<EstudanteResponse>> getEstudantes(){

        var estudantes = this.service.getEstudantes();
        return ResponseEntity.ok(EstudantesMapper.toDTOList(estudantes));
    }

    @GetMapping("{id}")
    public ResponseEntity<EstudanteResponse>getEstudantes(@PathVariable long id){
        var estudantes = this.service.getEstudante(id);
        return ResponseEntity.ok(EstudantesMapper.toDTO(estudantes));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEstudantes(@PathVariable long id){
        this.service.deleteEstudantesById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<EstudanteResponse> save(@Validated @RequestBody EstudanteRequest estudantes){
        var savedEstudantes = this.service.save(estudantes);

        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedEstudantes.id())

                .toUri();
                
        return ResponseEntity.created(location).body(savedEstudantes);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody Estudantes estudantes,
                                       @PathVariable long id
    ){
        this.service.update(id, estudantes);
        return ResponseEntity.ok().build();
    }
}
