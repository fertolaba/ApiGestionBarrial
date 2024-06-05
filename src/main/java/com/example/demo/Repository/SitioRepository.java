package com.example.demo.Repository;

import com.example.demo.entity.Sitio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SitioRepository extends JpaRepository<Sitio, Integer> {
}
