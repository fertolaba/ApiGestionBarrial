package com.example.demo.Service;

import com.example.demo.Repository.VecinoRepository;
import com.example.demo.entity.Vecino;
import com.example.demo.exceptions.VecinoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VecinoService {

    private final VecinoRepository vecinoRepository;

    @Autowired
    public VecinoService(VecinoRepository vecinoRepository) {
        this.vecinoRepository = vecinoRepository;
    }

    public List<Vecino> getVecinos() {
        return vecinoRepository.findAll();
    }

    public Vecino buscarPersonaDocumento(String documento) throws VecinoException {
        Optional<Vecino> optionalVecino = vecinoRepository.findByDocumento(documento);
        if (optionalVecino.isPresent()) {
            return optionalVecino.get();
        } else {
            throw new VecinoException("No se encontró el vecino con documento: " + documento);
        }
    }
}
