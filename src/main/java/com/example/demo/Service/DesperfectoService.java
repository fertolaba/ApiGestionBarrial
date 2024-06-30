package com.example.demo.Service;

import com.example.demo.Repository.DesperfectoRepository;
import com.example.demo.entity.Desperfecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DesperfectoService {

    @Autowired
    private final DesperfectoRepository desperfectoRepository;

    public DesperfectoService(DesperfectoRepository desperfectoRepository) {
        this.desperfectoRepository = desperfectoRepository;
    }

    public Desperfecto obtenerOcrearDesperfecto(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe especificar una descripcion");
        }

        return desperfectoRepository.findByDescripcion(descripcion);

    }

}
