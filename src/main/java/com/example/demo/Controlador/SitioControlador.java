package com.example.demo.Controlador;

import com.example.demo.Repository.SitioRepository;
import com.example.demo.Service.SitioService;
import com.example.demo.entity.Sitio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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

    @GetMapping("/documento/{documento}")
    public Optional<Sitio> obtenerSitioPorDocumento(@PathVariable String documento) {
        return sitioService.getSitioByDocumento(documento);
    }

    @PostMapping("/crear")
    public void crearSitio(@RequestBody Sitio sitio){
        sitioService.guardarSitio(sitio);
    }

    @PutMapping("/editar")
    public void editarSitio(@RequestBody Sitio sitio){
        sitioService.editarSitio(sitio);
    }
}
