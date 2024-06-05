package com.example.demo.Repository;

import com.example.demo.entity.Barrio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarrioRepository extends JpaRepository<Barrio, Integer> {
}
