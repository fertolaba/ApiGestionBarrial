package com.example.demo.Repository;

import com.example.demo.entity.Desperfecto;
import com.example.demo.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DesperfectoRepository extends JpaRepository<Desperfecto, Integer> {
    public Desperfecto findByDescripcion(String descripcion);
}
