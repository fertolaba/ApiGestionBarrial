package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.VecinoRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final VecinoRepository vecinoRepository;
    @Autowired
    private final MailService mailService;

    public UserService(UserRepository userRepository, VecinoRepository vecinoRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.vecinoRepository = vecinoRepository;
        this.mailService = mailService;
    }


    public void crearUsuario(User user){
        boolean existsInVecinos = vecinoRepository.existsByDocumento(user.getDocumento());

        if (!existsInVecinos) {
            String subject = "Solicitud de Registro Rechazada";
            String message = "Tu solicitud de registro ha sido rechazada.";
            mailService.sendEmail(user.getMail(), subject, message);
            throw new RuntimeException("No existe vecino con documento: " + user.getDocumento());

        }


        userRepository.save(user);
        String subject = "Confirmación de Registro";
        String message = "Tu registro ha sido confirmado.";
        mailService.sendEmail(user.getMail(), subject, message);
    }

    public void actualizarPassword(String mail, String password) {
        User user = userRepository.findByMail(mail)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con mail: " + mail));

        // Actualiza la contraseña del usuario
        user.setPassword(password);
        userRepository.save(user);
    }

    public boolean verificarEmailDocumento(String documento, String mail) {
        // Verificar si el correo electrónico está asociado al documento
        User user = userRepository.findByMailAndDocumento(mail, documento)
                .orElse(null);

        return user != null;
    }
}
