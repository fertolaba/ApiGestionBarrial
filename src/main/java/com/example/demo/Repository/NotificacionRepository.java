package com.example.demo.Repository;


import com.example.demo.entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    // Puedes añadir consultas personalizadas aquí si es necesario
}
