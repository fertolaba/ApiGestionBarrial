package com.example.demo.Controlador;

import com.example.demo.Repository.PersonalRepository;
import com.example.demo.Repository.VecinoRepository;
import com.example.demo.Service.VecinoService;
import com.example.demo.entity.Personal;
import com.example.demo.entity.Vecino;
import com.example.demo.exceptions.SitioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/vecinos")
public class VecinoControlador {

    @Autowired
    private VecinoService vecinoService;
    @Autowired
    private VecinoRepository vecinoRepository;

    @Autowired
    private PersonalRepository personalRepository;

    @GetMapping("/listar")
    public List<Vecino> listarVecinos() {
        return vecinoService.getVecinos();
    }

    @GetMapping("buscar/{documento}")
    public ResponseEntity<?> buscarVecinoDocumento(@PathVariable String documento){
        try {
            Vecino vecino = vecinoService.buscarPersonaDocumento(documento);
            return new ResponseEntity<>(vecino, HttpStatus.OK);
        } catch (SitioException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
















}