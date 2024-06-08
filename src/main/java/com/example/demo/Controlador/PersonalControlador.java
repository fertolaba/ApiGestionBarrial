package com.example.demo.Controlador;


import com.example.demo.Repository.PersonalRepository;
import com.example.demo.entity.Personal;
import com.example.demo.entity.Vecino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/personal")
public class PersonalControlador {
    @Autowired
    private PersonalRepository personalRepository;

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam Integer legajo, @RequestParam String password) {
        Optional<Personal> personalOptional = personalRepository.findByLegajo(legajo);

        if (personalOptional.isPresent()) {
            Personal personal = personalOptional.get();
            if (personal.getPassword().equals(password)) {
                // La autenticación es exitosa
                return ResponseEntity.ok("Bienvenido, eres un inspector.");
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
