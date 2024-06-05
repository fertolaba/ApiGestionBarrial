package com.example.demo.Controlador;

import com.example.demo.Repository.VecinoRepository;
import com.example.demo.Service.VecinoService;
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

    @PostMapping("/actualizar")
    public ResponseEntity<String> actualizarDatosVecino(@RequestParam String documento,
                                                        @RequestParam String email,
                                                        @RequestParam String password) {
        Optional<Vecino> vecinoOptional = vecinoRepository.findByDocumento(documento);

        if (vecinoOptional.isPresent()) {
            Vecino vecino = vecinoOptional.get();
            vecino.setEmail(email);
            vecino.setPassword(password);
            vecinoRepository.save(vecino); // Actualizar los campos email y password del vecino
            return ResponseEntity.ok("Datos actualizados correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vecino no encontrado");
        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        Optional<Vecino> vecinoOptional = vecinoRepository.findByEmail(email);

        if (vecinoOptional.isPresent()) {
            Vecino vecino = vecinoOptional.get();
            if (vecino.getPassword().equals(password)) {
                // La autenticación es exitosa
                return ResponseEntity.ok("Bienvenido, eres un vecino.");
            } else {
                // Contraseña incorrecta
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
            }
        } else {
            // Usuario no encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vecino no encontrado");
        }
    }













}