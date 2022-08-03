package umg.edu.demospring.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.edu.demospring.domain.repository.CarreraRepository;
import umg.edu.demospring.persistence.entity.Carrera;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraServiceImpl implements CarreraService{

    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public Carrera saveCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public List<Carrera> fetchCarreraList() {
        return (List<Carrera>) carreraRepository.findAll();
    }

    @Override
    public Optional<Carrera> getCarrera(Integer codigo) {
        return carreraRepository.findById(codigo);
    }

    @Override
    public Carrera updateCarrera(Carrera carrera, Integer codigo) {
        Optional<Carrera> carreraDb = getCarrera(codigo);
        if(carreraDb.isPresent()){
            carreraDb.get().setNombre(carrera.getNombre());
            carreraRepository.save(carreraDb.get());
        }
        return carreraDb.get();
    }

    @Override
    public boolean deleteCarreraById(Integer codigo) {
        if(getCarrera(codigo).isPresent()){
            carreraRepository.deleteById(codigo);
            return true;
        }
        return false;
    }
}
