package com.example.demo.Controlador;


import com.example.demo.DTO.AltaUsuarioVecinoRequest;
import com.example.demo.Service.AuthService;
import com.example.demo.Service.MailService;
import com.example.demo.Service.UserService;
import com.example.demo.entity.LoginRequest;
import com.example.demo.entity.User;
import com.example.demo.entity.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/auth")
public class AuthControlador {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

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
            throw new RuntimeException("El correo electrónico no está asociado al documento proporcionado. Cuenta no existe.");
        }
    }
}
