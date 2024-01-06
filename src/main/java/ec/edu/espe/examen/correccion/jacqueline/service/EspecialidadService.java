package ec.edu.espe.examen.correccion.jacqueline.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import ec.edu.espe.examen.correccion.jacqueline.domain.Especialidad;
import ec.edu.espe.examen.correccion.jacqueline.dao.EspecialidadRepository;
import jakarta.transaction.Transactional;

@Service
public class EspecialidadService {
    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }


   @Transactional
    public Especialidad create(Especialidad especialidad){
        Optional<Especialidad> especialidadTmp = this.especialidadRepository.findByNombre(especialidad.getNombre());
        if (!especialidadTmp.isPresent()) {
            return this.especialidadRepository.save(especialidad);
        } else {
            throw new RuntimeException("La especialidad ya existe");
        }
    }

    public List<Especialidad> findByNombreContaining(String nombre) {
        return this.especialidadRepository.findByNombreContaining(nombre);
    }
}

