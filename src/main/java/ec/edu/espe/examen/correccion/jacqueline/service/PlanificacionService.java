package ec.edu.espe.examen.correccion.jacqueline.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.correccion.jacqueline.dao.MateriaRepository;
import ec.edu.espe.examen.correccion.jacqueline.dao.DocenteMateriaRepository;
import ec.edu.espe.examen.correccion.jacqueline.dao.DocenteRepository;
import ec.edu.espe.examen.correccion.jacqueline.domain.Docente;
import ec.edu.espe.examen.correccion.jacqueline.domain.DocenteMateria;
import ec.edu.espe.examen.correccion.jacqueline.domain.Materia;
import jakarta.transaction.Transactional;

@Service
public class PlanificacionService {

    private final DocenteRepository docenteRepository;
    private final MateriaRepository materiaRepository;
    private final DocenteMateriaRepository docenteMateriaRepository;

    public PlanificacionService(MateriaRepository materiaRepository, DocenteRepository docenteRepository,
            DocenteMateriaRepository docenteMateriaRepository) {
        this.materiaRepository = materiaRepository;
        this.docenteRepository = docenteRepository;
        this.docenteMateriaRepository = docenteMateriaRepository;
    }

    @Transactional
    public DocenteMateria asignarDocenteMateria(DocenteMateria docenteMateria) {
            Optional<Docente> optionalDocente = this.docenteRepository.findById( docenteMateria.getPk().getCodigoDocente());
            Optional<Materia> optionalMateria = this.materiaRepository.findById( docenteMateria.getPk().getCodigoMateria());

            if (optionalDocente.isPresent()) {
                if (optionalMateria.isPresent()) {
                    Optional<DocenteMateria> optionalDocenteMateria = this.docenteMateriaRepository.findById(docenteMateria.getPk());
                    if (!optionalDocenteMateria.isPresent()) {
                        return this.docenteMateriaRepository.save(docenteMateria);
                    } else {
                        throw new RuntimeException("Docente ya ha sido asignado a la Materia");
                    }
                } else {
                    throw new RuntimeException("Materia no existe");
                }
            } else {
                throw new RuntimeException("Docente no existe");
            }
    }

    public Iterable<DocenteMateria> findAll() {
        return this.docenteMateriaRepository.findAll();
    }

    public Optional<DocenteMateria> findByDocente(Long codDocente) {
        return this.docenteMateriaRepository.findByPk_CodigoDocente(codDocente);
    }
}
