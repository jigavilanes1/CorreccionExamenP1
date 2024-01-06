package ec.edu.espe.examen.correccion.jacqueline.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.correccion.jacqueline.domain.DocenteMateria;
import ec.edu.espe.examen.correccion.jacqueline.service.PlanificacionService;

@RestController
@RequestMapping("/planificacion")
public class PlanificacionController {

    private PlanificacionService planificacionService;

    public PlanificacionController(PlanificacionService planificacionService) {
        this.planificacionService = planificacionService;
    }

    @PostMapping("/asignar")
    public ResponseEntity<DocenteMateria> asignarDocenteMateria(@RequestBody DocenteMateria docenteMateria) {
        return ResponseEntity.ok().body(this.planificacionService.asignarDocenteMateria(docenteMateria));
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<DocenteMateria>> findAll() {
        return ResponseEntity.ok().body(this.planificacionService.findAll());
    }

    @GetMapping("/alumno/{codAlumno}")
    public ResponseEntity<Optional<DocenteMateria>> findByAlumno(@PathVariable Long codDocente) {
        return ResponseEntity.ok().body(this.planificacionService.findByDocente(codDocente));
    }
}
