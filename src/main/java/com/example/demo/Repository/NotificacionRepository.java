package com.example.demo.Repository;


import com.example.demo.entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    @Query("SELECT n FROM Notificacion n WHERE n.vecino.documento = :documento")
    List<Notificacion> findByDocumento(@Param("documento") String documento);
}