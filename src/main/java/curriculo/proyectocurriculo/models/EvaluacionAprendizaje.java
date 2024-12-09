package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "evaluacion_aprendizaje")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvaluacionAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEvaluacion;

    @ManyToOne
    @JoinColumn(name = "id_resultado_aprendizaje", nullable = false)
    private ResultadoAprendizaje resultadoAprendizaje;

    private String estrategiasEvaluacion;
    private String actividadesEvaluacion;
}

