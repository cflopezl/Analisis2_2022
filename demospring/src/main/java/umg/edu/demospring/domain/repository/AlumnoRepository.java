package umg.edu.demospring.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import umg.edu.demospring.persistence.entity.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {
}
