package com.estudantes.estudantes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudantes.estudantes.dtos.EstudanteRequest;
import com.estudantes.estudantes.dtos.EstudanteResponse;
import com.estudantes.estudantes.entities.Estudantes;
import com.estudantes.estudantes.mappers.EstudantesMapper;
import com.estudantes.estudantes.repositories.EstudantesRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EstudantesService {
    
    @Autowired
    private EstudantesRepository repository;

    public List<Estudantes> getEstudantes(){
        return this.repository.findAll();
    }

    public Estudantes getEstudante(long id){
        return this.repository.findById(id).orElseThrow(
                                                () -> new EntityNotFoundException("Estudante not found")

                                                
                                            );
    }

    public void deleteEstudantesById(long id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Estudante not found");
        }
    }

    public EstudanteResponse save(EstudanteRequest product){
        var entity = this.repository.save(EstudantesMapper.toEntity(product));
        return EstudantesMapper.toDTO(entity);
    }

    public void update(long id, Estudantes estudantes) {
       
        try{
            var updateEstudantes = this.repository.getReferenceById(id);
            updateEstudantes.setName(estudantes.getName());
            updateEstudantes.setEmail(estudantes.getEmail());
            updateEstudantes.setCourse(estudantes.getCourse());
            updateEstudantes.setTelefone(estudantes.getTelefone());
            this.repository.save(updateEstudantes);
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Estudante not found");
        }
        
    }
}
