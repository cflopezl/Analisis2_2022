package umg.edu.demospring.domain.repository;

import org.springframework.data.repository.CrudRepository;
import umg.edu.demospring.persistence.entity.Carrera;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    Carrera getCarreraByCodigo(Integer codigo);
}
