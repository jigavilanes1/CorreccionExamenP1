package ec.edu.espe.examen.correccion.jacqueline.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examen.correccion.jacqueline.domain.Docente;

public interface  DocenteRepository extends CrudRepository<Docente, Long> {
    Optional<Docente> findByCedula(String cedula);
}