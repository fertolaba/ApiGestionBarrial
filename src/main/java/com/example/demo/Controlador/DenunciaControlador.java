package com.example.demo.Controlador;

import com.example.demo.Repository.DenunciaRepository;
import com.example.demo.Service.DenunciaService;
import com.example.demo.entity.Denuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/denuncia")
public class DenunciaControlador {

    @Autowired
    private DenunciaRepository denunciaRepository;
    @Autowired
    private DenunciaService denunciaService;

    @PostMapping("/crear")
    public void crearDenuncia(@RequestBody Denuncia denuncia){

        System.out.println(denuncia.getVecino().getDocumento());
        denunciaService.crearDenuncia(denuncia);
    }

    @GetMapping("/listar")
    public List<Denuncia> listarDenuncias() {
        return denunciaService.getDenuncias();
    }




}
