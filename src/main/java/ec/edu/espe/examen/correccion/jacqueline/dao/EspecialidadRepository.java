package ec.edu.espe.examen.correccion.jacqueline.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import ec.edu.espe.examen.correccion.jacqueline.domain.Especialidad;

public interface EspecialidadRepository extends JpaRepository<Especialidad, String> {
    Optional<Especialidad> findByNombre(String nombre);
    List<Especialidad> findByNombreContaining(String nombre);
}













