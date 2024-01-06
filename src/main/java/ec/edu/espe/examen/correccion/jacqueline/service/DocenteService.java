package ec.edu.espe.examen.correccion.jacqueline.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.correccion.jacqueline.domain.Docente;
import ec.edu.espe.examen.correccion.jacqueline.domain.Especialidad;
import ec.edu.espe.examen.correccion.jacqueline.dao.DocenteRepository;
import ec.edu.espe.examen.correccion.jacqueline.dao.EspecialidadRepository;
import jakarta.transaction.Transactional;

@Service
public class DocenteService {
    private final DocenteRepository docenteRepository;
    private EspecialidadRepository especialidadRepository;

    public DocenteService(DocenteRepository docenteRepository, EspecialidadRepository especialidadRepository) {
        this.docenteRepository = docenteRepository;
        this.especialidadRepository = especialidadRepository;
    }

    @Transactional
    public Docente create(Docente docente) {
        try {
            String codigoEspecialidad = docente.getCodEspecialidad();
            Optional<Especialidad> especialidad = this.especialidadRepository.findById(codigoEspecialidad);
            if (especialidad.isPresent()) {
                Date fechaIngreso = docente.getFechaIngreso();
                Date fechaActual = new Date();

                if (fechaIngreso.before(fechaActual)) {
                    throw new RuntimeException("La fecha de ingreso debe ser posterior a la fecha actual");
                }
                return this.docenteRepository.save(docente);
            } else {
                throw new RuntimeException("La especialidad no existe");
            }
        } catch (Exception e) {
            throw new CreacionExcepcion("Error en crear docente: "
                    + docente.getCodigo() + ": " + e);
        }
    }

    public Iterable<Docente> findAll() {
        return this.docenteRepository.findAll();
    }
}