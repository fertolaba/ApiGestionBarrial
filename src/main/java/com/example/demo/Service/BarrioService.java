package com.example.demo.Service;

import com.example.demo.Repository.BarrioRepository;
import com.example.demo.entity.Barrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarrioService {

    @Autowired
    private final BarrioRepository barrioRepository;

    public BarrioService(BarrioRepository barrioRepository) {
        this.barrioRepository = barrioRepository;
    }

    public void crearBarrio(Barrio barrio) {
        barrioRepository.save(barrio);
    }

    public List<Barrio> getBarrios(){
        return barrioRepository.findAll();
    }


}
