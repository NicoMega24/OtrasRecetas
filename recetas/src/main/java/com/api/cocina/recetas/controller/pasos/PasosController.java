package com.api.cocina.recetas.controller.pasos;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cocina.recetas.dto.steps.PasosDto;
import com.api.cocina.recetas.exceptions.PasoNoEncontradoException;
import com.api.cocina.recetas.service.pasos.PasosService;

@RestController
@RequestMapping("/api/v1/pasos")
public class PasosController {
    
    private final PasosService pasosService;
    
    @Autowired
    public PasosController(PasosService pasosService) {
        this.pasosService = pasosService;
    }
    
    @PostMapping
    public ResponseEntity<PasosDto> crearPaso(@RequestBody PasosDto pasosDto) {
        PasosDto creado = pasosService.crearPaso(pasosDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    
    @GetMapping
    public ResponseEntity<List<PasosDto>> listarPasos() {
        List<PasosDto> pasos = pasosService.listarPasos();
        return ResponseEntity.ok(pasos);
    }
    
    @GetMapping("/obtenerPaso/{id}")
    public ResponseEntity<PasosDto> obtenerPaso(@PathVariable UUID id) {
        try {
            PasosDto paso = pasosService.obtenerPaso(id);
            return ResponseEntity.ok(paso);
        } catch (PasoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/actualizarPaso/{id}")
    public ResponseEntity<PasosDto> actualizarPaso(@PathVariable UUID id, @RequestBody PasosDto pasosDto) {
        try {
            PasosDto actualizado = pasosService.actualizarPaso(id, pasosDto);
            return ResponseEntity.ok(actualizado);
        } catch (PasoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/eliminarPaso/{id}")
    public ResponseEntity<Void> eliminarPaso(@PathVariable UUID id) {
        try {
            pasosService.eliminarPaso(id);
            return ResponseEntity.noContent().build();
        } catch (PasoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
