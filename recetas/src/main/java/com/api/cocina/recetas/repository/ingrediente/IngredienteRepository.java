package com.api.cocina.recetas.repository.ingrediente;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cocina.recetas.domain.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, UUID> {

}
