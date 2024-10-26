package com.api.cocina.recetas.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pasos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID", strategy= "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length= 36, columnDefinition= "varchar(36)", updatable= false, nullable= false )
    private UUID id;
    
    private String descripcion;

    private Integer tiempoEstimado;

    private Boolean opcional;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;
    @ManyToMany
    @JoinTable(
        name = "pasos_ingrediente",
        joinColumns = @JoinColumn(name = "pasos_id"),
        inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )

    private List<Ingrediente> ingredientes;

    public Pasos(UUID id, String descripcion, Integer tiempoEstimado, Boolean opcional, Receta receta) {
        this.id = id;
        this.descripcion = descripcion;
        this.tiempoEstimado = tiempoEstimado;
        this.opcional = opcional;
        this.receta = receta;
        this.ingredientes = new ArrayList<>();
    }


}
