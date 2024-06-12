package com.example.demo.Repository;

import com.example.demo.entity.Denuncia;
import com.example.demo.entity.MovimientoReclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoReclamoRepository  extends JpaRepository<MovimientoReclamo, Integer> {
}
