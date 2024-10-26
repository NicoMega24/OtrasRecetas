package com.api.cocina.recetas.service.pasos;

import java.util.List;
import java.util.UUID;

import com.api.cocina.recetas.dto.steps.PasosDto;

public interface PasosService {
    PasosDto crearPaso(PasosDto pasosDto);
    List<PasosDto> listarPasos();
    PasosDto obtenerPaso(UUID id);
    PasosDto actualizarPaso(UUID id, PasosDto pasosDto);
    void eliminarPaso(UUID id);
}