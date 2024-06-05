package com.example.demo.Controlador;

import com.example.demo.Repository.ReclamoRepository;
import com.example.demo.Service.ReclamoService;
import com.example.demo.entity.Reclamo;
import com.example.demo.entity.Sitio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/reclamos")
public class ReclamoControlador {
    @Autowired
    private ReclamoRepository reclamoRepository;
    @Autowired
    private ReclamoService reclamoService;

    @PostMapping("/crear")
    public void crearProducto(@RequestBody Reclamo reclamo){
        reclamoService.crearReclamo(reclamo);
    }

    @GetMapping("/listar")
    public List<Reclamo> listarReclamos() {
        return reclamoService.getReclamos();
    }


}
