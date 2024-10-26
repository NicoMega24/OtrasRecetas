package com.api.cocina.recetas.repository.pasos;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cocina.recetas.domain.Pasos;
import com.api.cocina.recetas.domain.Receta;

public interface PasosRepository extends JpaRepository<Pasos, UUID> {
    List<Pasos> findByReceta(Receta receta);

    List<Pasos> findByRecetaId(UUID id);
}
