package ec.edu.espe.examen.correccion.jacqueline.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.correccion.jacqueline.domain.Docente;
import ec.edu.espe.examen.correccion.jacqueline.service.DocenteService;

@RestController
@RequestMapping("/docente")

public class DocenteController {
    private DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Docente> save(@RequestBody Docente docente) {
        return ResponseEntity.ok().body(this.docenteService.create(docente));
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Docente>> findAll() {
        return ResponseEntity.ok().body(this.docenteService.findAll());
    }
}
