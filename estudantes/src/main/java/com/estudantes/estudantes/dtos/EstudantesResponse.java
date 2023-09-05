package com.estudantes.estudantes.dtos;

public record EstudantesResponse(
    Long id,
    String name,
    String email,
    String course,
    String telefone
) {
    
}
