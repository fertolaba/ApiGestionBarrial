package com.example.demo.Service;

import com.example.demo.DTO.ActualizarEstadoReclamoDTO;
import com.example.demo.Repository.ReclamoRepository;
import com.example.demo.entity.Desperfecto;
import com.example.demo.entity.Reclamo;
import com.example.demo.entity.Sitio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamoService {

    @Autowired
    private final ReclamoRepository reclamoRepository;

    public ReclamoService(ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    public Reclamo crearReclamo(Reclamo reclamo) {

        return reclamoRepository.save(reclamo);
    }

    public Optional<Reclamo> getReclamoById(Integer idReclamo) {
        return reclamoRepository.findById(idReclamo);
    }

    public List<Reclamo> getReclamosByEstado(String estado) {
        return reclamoRepository.findByEstado(estado);
    }

    public List<Reclamo> getReclamos() {
        return reclamoRepository.findAll();
    }

    public List<Reclamo> getReclamosByDocumento(String documento) {
        return reclamoRepository.findByVecinoDocumento(documento);
    }

    public List<Reclamo> getReclamosByLegajo(int legajo) {
        return reclamoRepository.findByPersonalLegajo(legajo);
    }

    public List<Reclamo> getReclamosByDesperfectoAndSitio(Desperfecto desperfecto, Sitio sitio) {
        return reclamoRepository.findByDesperfectoAndSitio(desperfecto, sitio);
    }

    // todo puesto en el controller // XD
    // public Optional<Reclamo> actualizarEstadoReclamo(ActualizarEstadoReclamoDTO actualizarEstadoReclamoDTO) {
    //     Optional<Reclamo> reclamo = reclamoRepository.findById(actualizarEstadoReclamoDTO.getReclamo().getIdreclamo());
    //     if (reclamo.isPresent()) {
    //         reclamo.get().setEstado(estado);
    //         reclamoRepository.save(reclamo.get());
    //     }
    //     return reclamo;
    // }
}
