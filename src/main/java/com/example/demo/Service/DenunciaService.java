package com.example.demo.Service;

import com.example.demo.Repository.DenunciaRepository;
import com.example.demo.entity.Denuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private final DenunciaRepository denunciaRepository;

    public DenunciaService(DenunciaRepository denunciaRepository) {
        this.denunciaRepository = denunciaRepository;
    }

    public void crearDenuncia(Denuncia denuncia) {
        denunciaRepository.save(denuncia);
    }

    public List<Denuncia> getDenuncias(){
        return denunciaRepository.findAll();
    }

    public List<Denuncia> buscarDenunciaPorDoc(String documento) {
        return denunciaRepository.findByVecinoDocumento(documento);
    }
}
