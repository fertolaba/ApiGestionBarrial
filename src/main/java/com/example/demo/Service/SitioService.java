package com.example.demo.Service;

import com.example.demo.Repository.SitioRepository;
import com.example.demo.entity.Barrio;
import com.example.demo.entity.Reclamo;
import com.example.demo.entity.Sitio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SitioService {
    @Autowired
    private SitioRepository sitioRepository;

    public Sitio guardarSitio(Sitio sitio) {
        sitio.setIdSitio(null);
        return sitioRepository.save(sitio);
    }
    public List<Sitio> getSitios(){
        return sitioRepository.findAll();
    }
}
