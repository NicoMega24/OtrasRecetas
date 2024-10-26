package com.api.cocina.recetas.service.receta;

import java.util.List;
import java.util.UUID;

import com.api.cocina.recetas.domain.enums.Dificultad;
import com.api.cocina.recetas.dto.ingredient.IngredienteDto;
import com.api.cocina.recetas.dto.recipe.RecetaDto;
import com.api.cocina.recetas.exceptions.RecetaNoEncontradaException;

public interface RecetaService {
    RecetaDto obtenerReceta(UUID id) throws RecetaNoEncontradaException;
    List<RecetaDto> listarRecetas();
    RecetaDto crearReceta(RecetaDto recetaDto);
    RecetaDto actualizarReceta(UUID id, RecetaDto receta) throws RecetaNoEncontradaException;
    void eliminarReceta(UUID id) throws RecetaNoEncontradaException;
    List<IngredienteDto> obtenerIngredientesDeReceta(UUID id);
    List<RecetaDto> buscarRecetasPorDificultad(Dificultad dificultad);
    Integer obtenerTiempoPreparacionDeReceta(UUID id);
}