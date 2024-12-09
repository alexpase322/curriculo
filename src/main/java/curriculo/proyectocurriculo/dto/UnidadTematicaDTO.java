package curriculo.proyectocurriculo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnidadTematicaDTO {
    private Integer numero;
    private String contenido;
    private String estrategiasDidacticas;
    private Integer horasTeoricas;
    private Integer horasTeoricoPracticas;
    private Integer horasPracticas;
    private Integer horasTrabajoIndependiente;
}

