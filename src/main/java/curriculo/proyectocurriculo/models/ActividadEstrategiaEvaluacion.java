package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actividad_estrategia_evaluacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadEstrategiaEvaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;

    @ManyToOne
    @JoinColumn(name = "id_resultado", nullable = false)
    private ResultadoAprendizaje resultadoAprendizaje;

    private String actividadAcademica;
    private String estrategiaEvaluacion;
}

