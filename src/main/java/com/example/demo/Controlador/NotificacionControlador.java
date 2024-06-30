package com.example.demo.Controlador;

import com.example.demo.Repository.NotificacionRepository;
import com.example.demo.Service.NotificacionService;
import com.example.demo.entity.Notificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/notificaciones")
public class NotificacionControlador {
    @Autowired

    private final NotificacionService notificacionService;
    private final NotificacionRepository notificacionRepository;

    public NotificacionControlador(NotificacionService notificacionService, NotificacionRepository notificacionRepository) {
        this.notificacionService = notificacionService;
        this.notificacionRepository = notificacionRepository;
    }

    @GetMapping("/documento/{documento}")
    public ResponseEntity<List<Notificacion>> obtenerNotificacionesParaDocumento(@PathVariable String documento) {
        List<Notificacion> notificacionesUsuario = notificacionRepository.findByDocumento(documento);

        if (notificacionesUsuario.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(notificacionesUsuario);
        }
    }
}
