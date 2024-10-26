package com.api.cocina.recetas.service.ingrediente;

import java.util.List;
import java.util.UUID;

import com.api.cocina.recetas.dto.ingredient.IngredienteDto;

public interface IngredienteService {
    IngredienteDto crearIngrediente(IngredienteDto ingredienteDto);
    List<IngredienteDto> listarIngredientes();
    IngredienteDto obtenerIngrediente(UUID id);
    IngredienteDto actualizarIngrediente(UUID id, IngredienteDto ingredienteDto);
    void eliminarIngrediente(UUID id);
}
