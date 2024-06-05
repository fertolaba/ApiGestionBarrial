package com.example.demo.Controlador;

import com.example.demo.Repository.VecinoRepository;
import com.example.demo.Service.VecinoService;
import com.example.demo.entity.Vecino;
import com.example.demo.exceptions.VecinoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path="/api/vecinos")
public class VecinoControlador {

    @Autowired
    private VecinoService vecinoService;
    @Autowired
    private VecinoRepository vecinoRepository;

    @GetMapping("/listar")
    public List<Vecino> listarVecinos() {
        return vecinoService.getVecinos();
    }

    @GetMapping("buscar/{documento}")
    public ResponseEntity<?> buscarVecinoDocumento(@PathVariable String documento){
        try {
            Vecino vecino = vecinoService.buscarPersonaDocumento(documento);
            return new ResponseEntity<>(vecino, HttpStatus.OK);
        } catch (VecinoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}