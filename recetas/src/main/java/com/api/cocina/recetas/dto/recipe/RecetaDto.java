package com.api.cocina.recetas.dto.recipe;

import java.util.UUID;

import com.api.cocina.recetas.domain.enums.Dificultad;

public record RecetaDto(
    UUID id,
    String nombre,
    String descripcion,
    Dificultad dificultad,
    Long categoria
) {

}
