package com.example.demo.Repository;

import com.example.demo.entity.Barrio;
import com.example.demo.entity.Denuncia;
import com.example.demo.entity.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
    List<Denuncia> findByVecinoDocumento(String documento);
}
