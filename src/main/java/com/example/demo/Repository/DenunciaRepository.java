package com.example.demo.Repository;

import com.example.demo.entity.Barrio;
import com.example.demo.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
}
