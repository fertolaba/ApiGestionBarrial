package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.VecinoRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

            throw new RuntimeException("No existe vecino con documento: " + user.getDocumento());

        }


        userRepository.save(user);
        String subject = "Confirmación de Registro";
        String message = "Hola " + user.getNombre() + ", tu registro ha sido confirmado.";
        mailService.sendEmail(user.getMail(), subject, message);
    }
}
