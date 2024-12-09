package curriculo.proyectocurriculo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EvaluacionAprendizajeDTO {
    private String estrategiasEvaluacion;
    private String actividadesEvaluacion;
}

