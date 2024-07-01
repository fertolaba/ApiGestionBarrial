package com.example.demo.Controlador;

import com.example.demo.DTO.ActualizarEstadoReclamoDTO;
import com.example.demo.DTO.DesperfectoDTO;
import com.example.demo.DTO.ReclamoDTO;
import com.example.demo.Repository.*;
import com.example.demo.Service.DesperfectoService;
import com.example.demo.Service.ReclamoService;
import com.example.demo.entity.*;
import com.example.demo.enums.EstadoEnum;
import com.example.demo.exceptions.ReclamoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping(path = "/api/reclamos")
public class ReclamoControlador {
    @Autowired
    private ReclamoRepository reclamoRepository;
    @Autowired
    private ReclamoService reclamoService;
    @Autowired
    private MovimientoReclamoRepository movimientoReclamoRepository;
    @Autowired
    private VecinoRepository vecinoRepository;
    @Autowired
    private SitioRepository sitioRepository;
    @Autowired
    private DesperfectoService desperfectoService;

    @Autowired
    private DesperfectoRepository desperfectoRepository;
    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private NotificacionRepository notificacionRepository;

    private void auxiliarGuardarReclamosUnificados(Reclamo reclamo, List<Reclamo> otrosReclamos) {
        Reclamo reclamoUnificadoOriginal = !otrosReclamos.isEmpty() ? otrosReclamos.get(0).getReclamoUnificado() : null;

        if (reclamoUnificadoOriginal != null) {
            reclamo.setReclamoUnificado(reclamoUnificadoOriginal);
        } else {
            reclamo.setReclamoUnificado(reclamo);
        }

        Desperfecto desperfecto = reclamo.getDesperfecto();
        for (Reclamo reclamoMismoDesperfecto : otrosReclamos) {
            if (reclamoUnificadoOriginal != null) {
                reclamoMismoDesperfecto.setReclamoUnificado(reclamoUnificadoOriginal);
            } else {
                reclamoMismoDesperfecto.setReclamoUnificado(reclamo);
            }
            reclamoMismoDesperfecto.setDesperfecto(desperfecto);
        }

        reclamoRepository.saveAll(otrosReclamos);
    }

    private List<Reclamo> auxiliarAnularFinalizarReclamosUnificados(Reclamo reclamo) {
        List<Reclamo> otrosReclamos = reclamoRepository.findByReclamoUnificado(reclamo.getReclamoUnificado());
        List<Reclamo> aSalvar = new ArrayList<>();

        for (Reclamo reclamoUnificado : otrosReclamos) {
            if (reclamoUnificado != null) {
                if (Objects.equals(reclamoUnificado.getEstado(), EstadoEnum.PENDIENTE.getEstado())) {
                    reclamoUnificado.setEstado(reclamo.getEstado());
                    aSalvar.add(reclamoUnificado);
                }
            }
        }
        if (!aSalvar.isEmpty()) return reclamoRepository.saveAll(otrosReclamos);
        return new ArrayList<Reclamo>();
    }

    @PostMapping("") // crea un reclamo ingresando el legajo y documento, tambien te pide un
    // desperfecto q seria del vecino , si es un inspector te pide un rubro
    public ResponseEntity<Reclamo> crearReclamo(@RequestBody ReclamoDTO reclamoDTO) {
        Reclamo reclamo = new Reclamo();
        Reclamo reclamoGuardado = null;
        Notificacion notificacionGuardada = null;
        MovimientoReclamo movimientoReclamoCreado = null;

        try {
            Vecino vecino = null;
            Personal personal = null;

            Sitio sitio = sitioRepository.findById(reclamoDTO.getIdsitio()).orElseThrow(() -> new ReclamoException("Sitio no encontrado"));

            // TODO: cambiar nombre al del servicio obtenerOcrearDesperfecto, ya no lo crea
            DesperfectoDTO desperfectoDTO = reclamoDTO.getIddesperfecto();

            Desperfecto desperfectoExistente = desperfectoService.obtenerOcrearDesperfecto(desperfectoDTO.getDescripcion());
            Desperfecto desperfecto = null;
            Reclamo reclamoUnificado = null;
            List<Reclamo> otrosReclamosMismoDesperfectoSitio = new ArrayList<Reclamo>();

            if (desperfectoExistente != null) {
                // Obtener reclamos por desperfecto y sitio
                otrosReclamosMismoDesperfectoSitio = reclamoService.getReclamosByDesperfectoAndSitio(desperfectoExistente, sitio);
                desperfecto = desperfectoExistente;

                for (Reclamo reclamoMismoDesperfectoSitio : otrosReclamosMismoDesperfectoSitio) {
                    if (reclamoMismoDesperfectoSitio.getReclamoUnificado() != null) {
                        reclamoUnificado = reclamoMismoDesperfectoSitio.getReclamoUnificado();
                        reclamoUnificado.setDesperfecto(reclamoMismoDesperfectoSitio.getDesperfecto());
                        break; // No es necesario seguir buscando
                    }
                }
            } else {
                // Crear un nuevo desperfecto si no existe
                var nuevoDesperfecto = new Desperfecto();
                nuevoDesperfecto.setDescripcion(desperfectoDTO.getDescripcion());
                desperfecto = desperfectoRepository.save(nuevoDesperfecto);
            }

            var legajo = reclamoDTO.getLegajo();
            if (legajo == 0) { // si es personal no es vecino y viceersa
                vecino = vecinoRepository.findByDocumento(reclamoDTO.getDocumento()).orElseThrow(() -> new ReclamoException("Vecino no encontrado"));
            } else {
                personal = personalRepository.findById(legajo).orElseThrow(() -> new ReclamoException("Personal no encontrado"));
            }

            reclamo.setDescripcion(reclamoDTO.getDescripcion());
            reclamo.setVecino(vecino);
            reclamo.setSitio(sitio);
            reclamo.setDesperfecto(desperfecto);
            reclamo.setEstado(EstadoEnum.PENDIENTE.getEstado());
            reclamo.setPersonal(personal);

            reclamoGuardado = reclamoService.crearReclamo(reclamo);
            auxiliarGuardarReclamosUnificados(reclamoGuardado, otrosReclamosMismoDesperfectoSitio);

            if (reclamoGuardado != null && reclamoGuardado.getIdreclamo() != null) {
                MovimientoReclamo movimientoReclamo = new MovimientoReclamo();

                movimientoReclamo.setReclamo(reclamoGuardado);
                movimientoReclamo.setCausa("creado");
                movimientoReclamo.setFecha(LocalDateTime.now());
                movimientoReclamo.setResponsable("reclamos origen " + (legajo == 0 ? "vecinos" : "inspectores"));

                movimientoReclamoCreado = movimientoReclamoRepository.save(movimientoReclamo);
            }

            if (reclamoGuardado != null && reclamoGuardado.getIdreclamo() != null) {
                Notificacion notificacionUsuario = new Notificacion();
                notificacionUsuario.setFecha(new Date());
                notificacionUsuario.setVecino(vecino);
                notificacionUsuario.setMensaje("Su reclamo fue creado con el numero " + reclamoGuardado.getIdreclamo());
                notificacionUsuario.setReclamo(reclamoGuardado);

                notificacionGuardada = notificacionRepository.save(notificacionUsuario);
            }

        } catch (ReclamoException exception) {
            // Estaria bueno enviar con mensajes desde aca pero...
            return ResponseEntity.status(400).body(null);
        } // si hubiera otro podrian ponderse mas excepciones aca y enviar cosas
        // diferentes pero bueno, usemos codigo http en el front

        if (notificacionGuardada == null || notificacionGuardada.getIdnotificacion() == null) { // si se notifico, todo
            // salio bien, creo
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.status(201).body(reclamo);
    }

    @GetMapping("")
    public List<Reclamo> listarReclamos() {
        return reclamoService.getReclamos();
    }

    @GetMapping("/{idReclamo}")
    public Optional<Reclamo> obtenerReclamoPorId(@PathVariable Integer idReclamo) {
        return reclamoService.getReclamoById(idReclamo);
    }

    @GetMapping("/pendientes")
    public List<Reclamo> listarReclamosPendientes() {
        return reclamoService.getReclamosByEstado(EstadoEnum.PENDIENTE.getEstado());
    }

    @GetMapping("/finalizados")
    public List<Reclamo> listarReclamosFinalizados() {
        return reclamoService.getReclamosByEstado(EstadoEnum.FINALIZADO.getEstado());
    }

    @GetMapping("/documento/{documento}")
    public List<Reclamo> buscarReclamoPorDocumento(@PathVariable String documento) {
        return reclamoService.getReclamosByDocumento(documento);
    }

    @GetMapping("/legajo/{legajo}")
    public List<Reclamo> buscarReclamoPorLegajo(@PathVariable int legajo) {
        return reclamoService.getReclamosByLegajo(legajo);
    }

    @PostMapping("/actualizarEstado")
    public ResponseEntity<List<Reclamo>> actualizarEstado(@RequestBody ActualizarEstadoReclamoDTO reclamoDTO) {
        Reclamo reclamoRecuperado = null;
        EstadoEnum estado = reclamoDTO.getEstado();
        Reclamo reclamoActualizado = null;
        MovimientoReclamo movimientoReclamoActualizado = null;
        Notificacion notificacionUsuarioActualizado = null;
        Personal personal = null;
        List<Reclamo> listadoUnificados = null;

        var busquedaReclamo = reclamoRepository.findById(reclamoDTO.getReclamo().getIdreclamo());
        if (busquedaReclamo.isPresent()) {
            reclamoRecuperado = busquedaReclamo.get();
        }


        try {
            if (reclamoRecuperado == null) {
                throw new Exception("No se encontro reclamo");
            }

            // obtengo personal por legajo
            personal = personalRepository.findById(reclamoDTO.getLegajo()).orElseThrow(() -> new ReclamoException("Personal no encontrado"));

            if (estado == EstadoEnum.ANULADO || estado == EstadoEnum.FINALIZADO) {
                var estadoReclamo = reclamoRecuperado.getEstado();
                if (Objects.equals(estadoReclamo, EstadoEnum.ANULADO.getEstado()) || Objects.equals(estadoReclamo, EstadoEnum.FINALIZADO.getEstado())) {
                    throw new Exception("No se pueden actualizar reclamos que no esten pendientes");
                }

                reclamoRecuperado.setEstado(estado.getEstado());

                reclamoActualizado = reclamoRepository.save(reclamoRecuperado);

                if (reclamoActualizado.getIdreclamo() != null) {
                    MovimientoReclamo movimientoReclamo = new MovimientoReclamo();
                    String causa = "Actualizado a " + estado.getEstado() + " por el inspector " + personal.getNombre();

                    movimientoReclamo.setReclamo(reclamoActualizado);
                    movimientoReclamo.setCausa(causa);
                    movimientoReclamo.setFecha(LocalDateTime.now());
                    movimientoReclamo.setResponsable("inspector " + personal.getNombre() + " - legajo " + personal.getLegajo());

                    movimientoReclamoActualizado = movimientoReclamoRepository.save(movimientoReclamo);
                }

                if (movimientoReclamoActualizado != null && movimientoReclamoActualizado.getIdMovimiento() != null) {
                    var notificacionUsuario = new Notificacion();
                    notificacionUsuario.setFecha(new Date());
                    notificacionUsuario.setVecino(reclamoRecuperado.getVecino());
                    notificacionUsuario.setMensaje("Su reclamo con el numero fue " + reclamoRecuperado.getIdreclamo() + " fue " + estado.getEstado());
                    notificacionUsuario.setReclamo(reclamoActualizado);

                    notificacionUsuarioActualizado = notificacionRepository.save(notificacionUsuario);
                }

                if (notificacionUsuarioActualizado != null && notificacionUsuarioActualizado.getIdnotificacion() != null) {
                    listadoUnificados = auxiliarAnularFinalizarReclamosUnificados(reclamoActualizado);

                    return ResponseEntity.status(200).body(listadoUnificados);
                }

                return ResponseEntity.status(500).body(null);

            } else {
                // Manejo de error si el estado no es válido
                throw new IllegalArgumentException("Estado no válido");
            }
        } catch (Exception exception) {
        }

        if (reclamoActualizado != null && reclamoActualizado.getIdreclamo() != null) {
            return ResponseEntity.status(200).body(listadoUnificados);
        }

        return ResponseEntity.status(500).body(null);
    }
}
