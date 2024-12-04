package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "actividad_estrategia_evaluacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadEstrategiaEvaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idActividad;

    @ManyToOne
    @JoinColumn(name = "id_resultado", nullable = false)
    private ResultadoAprendizaje resultadoAprendizaje;

    private String actividadAcademica;
    private String estrategiaEvaluacion;
}

