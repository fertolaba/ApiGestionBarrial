package com.example.demo.Controlador;

import com.example.demo.DTO.DenunciaDTO;
import com.example.demo.DTO.DenunciaRequest;
import com.example.demo.DTO.SitioDTO;
import com.example.demo.DTO.SitioRequest;
import com.example.demo.Repository.DenunciaRepository;
import com.example.demo.Repository.SitioRepository;
import com.example.demo.Repository.VecinoRepository;
import com.example.demo.Service.DenunciaService;
import com.example.demo.entity.Denuncia;
import com.example.demo.entity.Reclamo;
import com.example.demo.entity.Sitio;
import com.example.demo.entity.Vecino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/denuncia")
public class DenunciaControlador {

    @Autowired
    private VecinoRepository vecinoRepository;
    @Autowired
    private DenunciaRepository denunciaRepository;
    @Autowired
    private DenunciaService denunciaService;
    @Autowired
    private SitioRepository sitioRepository;

    @PostMapping("/") //nose xq me toma aceptarepsonsabilidad como 0 cuando creas una denuncia
    public void crearDenuncia(@RequestBody DenunciaRequest denunciaRequest){
        Denuncia denuncias = new Denuncia();
        Vecino vecino = vecinoRepository.findByDocumento(denunciaRequest.getDocumento())
                .orElseThrow(() -> new RuntimeException("Vecino no encontrado"));
        denuncias.setVecino(vecino);

        SitioRequest sitioRequest = denunciaRequest.getSitio();
        Sitio sitio = sitioRepository.findByNumeroAndCalle(sitioRequest.getNumero(), sitioRequest.getCalle())
                .orElseThrow(() -> new RuntimeException("Sitio no encontrado"));
        denuncias.setSitio(sitio);

        denuncias.setDescripcion(denunciaRequest.getDescripcion());
        denuncias.setAceptaResponsabilidad(denunciaRequest.getAceptaresponsabilidad());

        denunciaService.crearDenuncia(denuncias);
    }

    @GetMapping("/listar")
    public List<Denuncia> listarDenuncias() {
        return denunciaService.getDenuncias();
    }

    @GetMapping("/buscar/{documento}")
    public List<Denuncia> buscarDenunciaPorDocumento(@PathVariable String documento) {
        return denunciaService.buscarDenunciaPorDoc(documento);
    }


}
