package com.estudantes.estudantes.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.estudantes.estudantes.dtos.EstudanteRequest;
import com.estudantes.estudantes.dtos.EstudanteResponse;
import com.estudantes.estudantes.entities.Estudantes;

public class EstudantesMapper {
    
    public static Estudantes toEntity(EstudanteRequest request){
        Estudantes estudantes = new Estudantes();
        estudantes.setName(request.name());
        estudantes.setEmail(request.email());
        estudantes.setCourse(request.course());
        estudantes.setTelefone(request.telefone());
        return estudantes;
    }

    public static EstudanteResponse toDTO(Estudantes estudantes){
        return new EstudanteResponse(estudantes.getId(), 
                            estudantes.getName(),
                            estudantes.getEmail(),
                            estudantes.getCourse(),
                            estudantes.getTelefone());
    }

    public static List<EstudanteResponse> toDTOList(List<Estudantes> estudantes){
        return estudantes.stream()      
               .map(EstudantesMapper::toDTO)
               .collect(Collectors.toList());
    }
}
