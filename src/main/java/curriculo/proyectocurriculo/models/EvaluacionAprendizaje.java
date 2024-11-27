package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "evaluacion_aprendizaje")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluacionAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvaluacion;

    @ManyToOne
    @JoinColumn(name = "id_resultado_aprendizaje", nullable = false)
    private ResultadoAprendizaje resultadoAprendizaje;

    private String estrategiasEvaluacion;
    private String actividadesEvaluacion;
}

