package com.example.demo.Controlador;


import com.example.demo.Service.AuthService;
import com.example.demo.entity.LoginRequest;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/auth")
public class AuthControlador {
    @Autowired
    private AuthService authService;

    @PostMapping("/crearsp")
    public void crearSp() {
        authService.createProcedureGetUserInfo();
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest) {
        return authService.getUserInfo(loginRequest.getIdentificador(), loginRequest.getPassword());
    }
}
