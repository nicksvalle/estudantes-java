package com.estudantes.estudantes.dtos;

public record EstudantesResponse(
    Long id,
    String name,
    String email,
    String telefone,
    String course
) {
    
}
