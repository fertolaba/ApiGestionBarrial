package com.example.demo.Service;

import com.example.demo.DTO.AltaUsuarioVecinoRequest;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.VecinoRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

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


    public void crearUsuario(User user) {
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
        User userFound = userRepository.findByMail(mail)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con mail: " + mail));

        userFound.setPassword(password);
        // Actualiza la contraseña);
        userRepository.save(userFound);
    }

    public boolean verificarEmailDocumento(String documento, String mail) {
        // Verificar si el correo electrónico está asociado al documento
        User user = userRepository.findByMailAndDocumento(mail, documento)
                .orElse(null);

        return user != null;
    }


    public void procesarSolicitud(AltaUsuarioVecinoRequest vecinoRequest) {
        String mail = vecinoRequest.getMail();

        if (vecinoRequest.isAceptado()) {
            var vecino = vecinoRepository.findByDocumento(vecinoRequest.getDocumento());

            if (vecino.isPresent()) {

                String generatedPassword = generarContrasenaAleatoria();

                User usuario = new User();
                usuario.setDocumento(vecinoRequest.getDocumento());
                usuario.setMail(mail);
                usuario.setPassword(generatedPassword);
                usuario.setExpiraContrasena(java.sql.Date.valueOf(java.time.LocalDate.now().minusDays(1))); // hoy -1 dia, asi figura vencido
                userRepository.save(usuario);

                enviarCorreo(mail, "Alta Satisfactoria", "Su alta ha sido aceptada. Su contraseña temporal es: " + generatedPassword);
                return;
            }
        }

        // CUalquier tema que haya impedido dar alta, envia mail de rechazo
        enviarCorreo(mail, "Alta Rechazada", "Su solicitud de alta ha sido rechazada - Contactese con el municipio.");
    }

    private String generarContrasenaAleatoria() {
        int length = 6;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();
    }

    private void enviarCorreo(String to, String subject, String text) {
        mailService.sendEmail(to, subject, text);
    }
}
