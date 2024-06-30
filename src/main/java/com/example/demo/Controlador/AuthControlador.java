package com.example.demo.Controlador;


import com.example.demo.Service.AuthService;
import com.example.demo.Service.MailService;
import com.example.demo.Service.UserService;
import com.example.demo.entity.LoginRequest;
import com.example.demo.entity.User;
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
    public User login(@RequestBody LoginRequest loginRequest) {
        return authService.getUserInfo(loginRequest.getDocumento(), loginRequest.getPassword());
    }
    @PostMapping("/alta")
    public void altaUsuario(@RequestBody User user) {

        userService.crearUsuario(user);

    }
}
