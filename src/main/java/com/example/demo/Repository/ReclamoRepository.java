package com.example.demo.Repository;

import com.example.demo.entity.Desperfecto;
import com.example.demo.entity.Reclamo;
import com.example.demo.entity.Sitio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {

    List<Reclamo> findByVecinoDocumento(String documento);

    List<Reclamo> findByPersonalLegajo(int legajo);

    List<Reclamo> findByEstado(String estado);

    List<Reclamo> findByDesperfectoAndSitio(Desperfecto desperfecto, Sitio sitio);
}
