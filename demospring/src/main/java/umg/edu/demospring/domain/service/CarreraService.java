package umg.edu.demospring.domain.service;

import umg.edu.demospring.persistence.entity.Carrera;

import java.util.List;
import java.util.Optional;

public interface CarreraService {

    Carrera saveCarrera(Carrera carrera);

    List<Carrera> fetchCarreraList();

    Optional<Carrera> getCarrera(Integer codigo);

    Carrera updateCarrera(Carrera carrera, Integer codigo);

    boolean deleteCarreraById(Integer codigo);
}
