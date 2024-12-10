package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCurso;

    @ManyToOne
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    private String nombre;
    private String codigo;
    private Integer numeroCreditos;
    private Integer horasAcompanamiento;
    private Integer horasTrabajoIndependiente;
    private Integer totalHoras;
    private String caracter;
    private String componente;
    private String requisito;
    private String unidadResponsable;
    private String presentacion;
    private String justificacion;
    private Integer periodoAcademico;
}
