package com.example.demo.Controlador;


import com.example.demo.Service.AuthService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/auth")
public class AuthControlador {
    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public User login(@RequestParam String identificador, @RequestParam String password) {
        return authService.getUserInfo(identificador, password);
    }
}
