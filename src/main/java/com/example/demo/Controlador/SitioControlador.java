package com.example.demo.Controlador;

import com.example.demo.Repository.SitioRepository;
import com.example.demo.Service.SitioService;
import com.example.demo.entity.Reclamo;
import com.example.demo.entity.Sitio;
import com.example.demo.entity.Vecino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/sitios")
public class SitioControlador {
    @Autowired
    private SitioService sitioService;
    @Autowired
    private SitioRepository sitioRepository;

    @GetMapping("/listar")
    public List<Sitio> listarSitios() {
        return sitioService.getSitios();
    }

    @PostMapping("/crear")
    public void crearSitio(@RequestBody Sitio sitio){
        sitioService.guardarSitio(sitio);
    }
}
