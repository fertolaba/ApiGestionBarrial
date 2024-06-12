package com.example.demo.Controlador;

import com.example.demo.DTO.DesperfectoDTO;
import com.example.demo.DTO.ReclamoDTO;
import com.example.demo.Repository.*;
import com.example.demo.Service.DesperfectoService;
import com.example.demo.Service.ReclamoService;
import com.example.demo.entity.*;
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
    @Autowired
    private MovimientoReclamoRepository movimientoReclamoRepository;
    @Autowired
    private VecinoRepository vecinoRepository;
    @Autowired
    private SitioRepository sitioRepository;
    @Autowired
    private DesperfectoService desperfectoService;

    @Autowired
    private DesperfectoRepository desperfectoRepository;
    @Autowired
    private PersonalRepository personalRepository;

    @PostMapping("/crear") //crea un reclamo ingresando el legajo y documento, tambien te pide un desperfecto q seria del vecino , si es un inspector te pide un rubro
    public void crearReclamo(@RequestBody ReclamoDTO reclamoDTO){
        Reclamo reclamo = new Reclamo();
        reclamo.setDescripcion(reclamoDTO.getDescripcion());

        Vecino vecino = vecinoRepository.findByDocumento(reclamoDTO.getDocumento())
                .orElseThrow(() -> new RuntimeException("Vecino no encontrado"));
        reclamo.setVecino(vecino);

        Sitio sitio = sitioRepository.findById(reclamoDTO.getIdsitio())
                .orElseThrow(() -> new RuntimeException("Sitio no encontrado"));
        reclamo.setSitio(sitio);


        DesperfectoDTO desperfectoDTO = reclamoDTO.getIddesperfecto();
        Desperfecto desperfecto = desperfectoService.obtenerOcrearDesperfecto(desperfectoDTO.getDescripcion());
        reclamo.setDesperfecto(desperfecto);

        Personal personal = personalRepository.findById(reclamoDTO.getLegajo())
                .orElseThrow(() -> new RuntimeException("Personal no encontrado"));
        reclamo.setPersonal(personal);

        reclamoService.crearReclamo(reclamo);
    }

    @GetMapping("/listar")
    public List<Reclamo> listarReclamos() {
        return reclamoService.getReclamos();
    }


}
