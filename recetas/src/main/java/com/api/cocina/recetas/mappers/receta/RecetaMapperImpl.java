package com.api.cocina.recetas.mappers.receta;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.cocina.recetas.domain.Categoria;
import com.api.cocina.recetas.domain.Receta;
import com.api.cocina.recetas.dto.recipe.RecetaDto;

@Service
public class RecetaMapperImpl implements RecetaMapper {
    @Override
    public RecetaDto toDTO(Receta receta) {
        return new RecetaDto(
            receta.getId(),
            receta.getNombre(),
            receta.getDescripcion(),
            receta.getDificultad(),
            receta.getCategoria().getId()
        );
    }
    
    @Override
    public Receta toEntity(RecetaDto recetaDto) {
        Categoria categoria = new Categoria(recetaDto.categoria(), "");
        return new Receta(
            UUID.randomUUID(),
            recetaDto.nombre(),
            recetaDto.descripcion(),
            recetaDto.dificultad(),
            categoria
        );
    }
}