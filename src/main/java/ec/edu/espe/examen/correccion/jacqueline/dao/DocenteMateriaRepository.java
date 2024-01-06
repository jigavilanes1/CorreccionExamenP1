package ec.edu.espe.examen.correccion.jacqueline.dao;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examen.correccion.jacqueline.domain.DocenteMateria;
import ec.edu.espe.examen.correccion.jacqueline.domain.DocenteMateriaPk;

import java.util.Optional;


public interface DocenteMateriaRepository extends CrudRepository<DocenteMateria, DocenteMateriaPk> {    

    Optional<DocenteMateria> findByPk_CodigoDocente(Long codigo);
}
