package com.api.cocina.recetas.dto.steps;

import java.util.List;
import java.util.UUID;

public record PasosDto(
        UUID id,
        String descripcion,
        Integer tiempoEstimado,
        Boolean opcional,
        Long receta,
        List<Long> ingredientes ) {

}
