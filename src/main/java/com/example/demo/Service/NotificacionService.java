package com.example.demo.Service;

import com.example.demo.Repository.NotificacionRepository;
import com.example.demo.entity.Notificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> getAllNotificaciones() {
        return notificacionRepository.findAll();
    }

    public Optional<Notificacion> getNotificacionById(int id) {
        return notificacionRepository.findById(id);
    }

    public Notificacion createNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Notificacion updateNotificacion(int id, Notificacion notificacionDetails) {
        Notificacion notificacion = notificacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Notificación no encontrada"));

        notificacion.setVecino(notificacionDetails.getVecino());
        notificacion.setFecha(notificacionDetails.getFecha());
        notificacion.setMensaje(notificacionDetails.getMensaje());
        notificacion.setDenuncia(notificacionDetails.getDenuncia());
        notificacion.setReclamo(notificacionDetails.getReclamo());

        return notificacionRepository.save(notificacion);
    }

    public void deleteNotificacion(int id) {
        Notificacion notificacion = notificacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
        notificacionRepository.delete(notificacion);
    }
}
