package com.example.demo.Service;

import com.example.demo.Repository.ReclamoRepository;
import com.example.demo.entity.Reclamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamoService {

    @Autowired
    private final ReclamoRepository reclamoRepository;

    public ReclamoService(ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    public void crearReclamo(Reclamo reclamo) {
        reclamoRepository.save(reclamo);
    }

    public List<Reclamo> getReclamos(){
        return reclamoRepository.findAll();
    }
}
