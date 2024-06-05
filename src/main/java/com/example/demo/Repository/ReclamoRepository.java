package com.example.demo.Repository;

import com.example.demo.entity.Reclamo;
import com.example.demo.entity.Vecino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {
}
