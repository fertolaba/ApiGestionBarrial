package com.example.demo.Controlador;

import com.example.demo.DTO.AltaUsuarioVecinoRequest;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.AuthService;
import com.example.demo.Service.MailService;
import com.example.demo.Service.UserService;
import com.example.demo.entity.LoginRequest;
import com.example.demo.entity.User;
import com.example.demo.entity.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthControlador {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @PostMapping("/login")
    public UserViewModel login(@RequestBody LoginRequest loginRequest) {
        return authService.getUserInfo(loginRequest.getDocumento(), loginRequest.getPassword());
    }

    @PostMapping("/alta")
    public void altaUsuario(@RequestBody User user) {
        userService.crearUsuario(user);
    }

    @PostMapping("/nuevo")
    public void nuevoUsuarioConEnvioEmail(@RequestBody AltaUsuarioVecinoRequest altaUsuarioVecinoRequest) {
        userService.procesarSolicitud(altaUsuarioVecinoRequest);
    }

    @PutMapping("/actualizar/{documento}")
    public void actualizarPass(@PathVariable String documento, @RequestBody User user) {
        // Verificar si el correo electrónico está asociado al documento proporcionado
        boolean emailDocumentoMatch = userService.verificarEmailDocumento(documento, user.getMail());

        if (emailDocumentoMatch) {
            // Si coincide, actualizar la contraseña
            userService.actualizarPassword(user.getMail(), user.getPassword());
        } else {
            throw new RuntimeException(
                    "El correo electrónico no está asociado al documento proporcionado. Cuenta no existe.");
        }
    }

    @PostMapping("/cambiarcontrasena/{documento}")
    public ResponseEntity<User> cambiarContrasena(@PathVariable String documento, @RequestBody User user) {
        var usuarioBuscado = userRepository.findByDocumento(documento);
        User updatedUser = null;

        if (usuarioBuscado.isPresent()) {
            if (Objects.equals(user.getPasswordAntiguo(), usuarioBuscado.get().getPassword())) {
                updatedUser = userService.actualizarPassword(usuarioBuscado.get().getMail(), user.getPassword());

                LocalDate hoy = LocalDate.now();
                LocalDate fechaEn90Dias = hoy.plusDays(90);
                Date nuevaFechaExpiracion = Date.valueOf(fechaEn90Dias);

                updatedUser.setExpiraContrasena(nuevaFechaExpiracion);

                userRepository.save(updatedUser);
            }
        }

        if (updatedUser != null && !Objects.equals(updatedUser.getDocumento(), "")) {
            return ResponseEntity.status(200).body(updatedUser);
        }
        return ResponseEntity.status(400).body(null);
    }
}
