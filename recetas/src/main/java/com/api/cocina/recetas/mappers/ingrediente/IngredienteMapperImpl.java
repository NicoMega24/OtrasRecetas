package com.api.cocina.recetas.mappers.ingrediente;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.cocina.recetas.domain.Ingrediente;
import com.api.cocina.recetas.dto.ingredient.IngredienteDto;

@Service
public class IngredienteMapperImpl implements IngredienteMapper {
    @Override
    public IngredienteDto toDTO(Ingrediente ingrediente) {
        return new IngredienteDto(
            ingrediente.getId(),
            ingrediente.getNombre(),
            ingrediente.getDescripcion()
        );
    }
    
    @Override
    public Ingrediente toEntity(IngredienteDto ingredienteDto) {
        return new Ingrediente(
            UUID.randomUUID(),
            ingredienteDto.nombre(),
            ingredienteDto.descripcion()
        );
    }
}