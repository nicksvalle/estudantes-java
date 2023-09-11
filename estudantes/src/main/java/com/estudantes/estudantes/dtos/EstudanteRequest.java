package com.estudantes.estudantes.dtos;

import jakarta.validation.constraints.NotBlank;

public record EstudanteRequest(
    @NotBlank(message = "Nome não pode ser em branco")
    String name,
    
    @NotBlank(message = "Email não pode ser em branco")
    String email,
    
    @NotBlank(message = "Curso não pode ser em branco")
    String course,

    @NotBlank(message = "Telefone não pode ser em branco")
    String telefone
) {
    
}
