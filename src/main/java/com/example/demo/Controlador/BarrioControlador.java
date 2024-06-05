package com.example.demo.Controlador;

import com.example.demo.Service.BarrioService;
import com.example.demo.entity.Barrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/barrio")
public class BarrioControlador {

    @Autowired
    private BarrioService barrioService;

    @GetMapping("/listar")
    public List<Barrio> listarBarrios(){
        return  barrioService.getBarrios();
    }

}
