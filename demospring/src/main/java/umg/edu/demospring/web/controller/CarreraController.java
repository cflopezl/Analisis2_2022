package umg.edu.demospring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import umg.edu.demospring.domain.service.CarreraService;
import umg.edu.demospring.persistence.entity.Carrera;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Carrera> fetchCarreraList()
    {
        List<Carrera> resultado = carreraService.fetchCarreraList();
        return resultado;
    }

    @PostMapping
    public Carrera saveCarrera(@Valid @RequestBody Carrera carrera){
        return carreraService.saveCarrera(carrera);
    }

    @GetMapping("/{codigo}")
    public Carrera fetchCarreraList(@PathVariable("codigo") Integer codigo)
    {
        return carreraService.getCarrera(codigo).get();
    }

    @DeleteMapping("/{codigo}")
    public boolean deleteCarrera(@PathVariable("codigo") Integer codigo)
    {
        return carreraService.deleteCarreraById(codigo);
    }

}
