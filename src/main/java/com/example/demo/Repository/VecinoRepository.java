package com.example.demo.Repository;

import com.example.demo.entity.Vecino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VecinoRepository extends JpaRepository<Vecino, Integer> {

    public Optional<Vecino> findByDocumento(String documento);



}
