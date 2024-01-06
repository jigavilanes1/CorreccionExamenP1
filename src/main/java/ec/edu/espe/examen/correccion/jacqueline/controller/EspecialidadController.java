package ec.edu.espe.examen.correccion.jacqueline.controller;

import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.correccion.jacqueline.domain.Especialidad;
import ec.edu.espe.examen.correccion.jacqueline.service.EspecialidadService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {

    private EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Especialidad> save(@RequestBody Especialidad especialidad) {
        return ResponseEntity.ok().body(this.especialidadService.create(especialidad));
    }

    @GetMapping("/listar/{nombre}")
    public ResponseEntity<List<Especialidad>> findByNombreContaining(@PathVariable String nombre) {
        return ResponseEntity.ok().body(this.especialidadService.findByNombreContaining(nombre));
    }
}
