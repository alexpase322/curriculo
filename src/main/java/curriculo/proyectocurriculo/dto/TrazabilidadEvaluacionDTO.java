package curriculo.proyectocurriculo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TrazabilidadEvaluacionDTO {
    private Date fechaEvaluacion;
    private String numeroActa;
    private String modificacion;
    private String justificacion;
    private String responsable;
}
