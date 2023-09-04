package com.estudantes.estudantes.mappers;

import com.estudantes.estudantes.dtos.EstudantesRequest;
import com.estudantes.estudantes.dtos.EstudantesResponse;
import com.estudantes.estudantes.entities.Estudantes;

public class EstudantesMapper {
    
    public static Estudantes toEntity(EstudantesRequest request){
        Estudantes estudantes = new Estudantes();
        estudantes.setName(request.name());
        estudantes.setEmail(request.email());
        estudantes.setCourse(request.course());
        estudantes.setTelefone(request.telefone());
        return estudantes;
    }

    public static EstudantesResponse toDTO(Estudantes estudantes){
        return new EstudantesResponse(estudantes.getId(), 
                            estudantes.getName(),
                            estudantes.getEmail(),
                            estudantes.getCourse(),
                            estudantes.getTelefone());
    }
}
