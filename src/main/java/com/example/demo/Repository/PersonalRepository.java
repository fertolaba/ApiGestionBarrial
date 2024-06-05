package com.example.demo.Repository;

import com.example.demo.entity.Denuncia;
import com.example.demo.entity.Personal;
import com.example.demo.entity.Vecino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {
    public Optional<Personal> findByLegajo(int legajo);
}
