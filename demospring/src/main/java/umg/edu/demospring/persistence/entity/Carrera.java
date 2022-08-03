package umg.edu.demospring.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carrera")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carrera {

    @Id
    @Column(name = "codigo")
    private Integer codigo;


    @Column
    private String nombre;


    @JsonManagedReference
    @OneToMany(mappedBy = "codigoCarrera")
    private List<Alumno> alumnos;

}
