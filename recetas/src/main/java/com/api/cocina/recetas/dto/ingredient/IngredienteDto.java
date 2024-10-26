package com.api.cocina.recetas.dto.ingredient;

import java.util.UUID;

public record IngredienteDto(
        UUID id,
        String nombre,
        String descripcion) {
}
