package curriculo.proyectocurriculo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActividadEstrategiaEvaluacionDTO {
    private String actividadAcademica;
    private String estrategiaEvaluacion;
}

