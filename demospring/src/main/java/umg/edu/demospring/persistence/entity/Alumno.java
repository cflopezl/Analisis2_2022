package umg.edu.demospring.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="alumno")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Alumno {

    @Id
    @Column
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String carne;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "codigo_carrera", insertable = false, updatable = false)
    private Carrera codigoCarrera;

}
