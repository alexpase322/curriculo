package curriculo.proyectocurriculo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramaDTO {
    private String nombrePrograma;
    private String tituloOtorgado;
    private String nivelFormacion;
    private String modalidad;
    private String duracionEstimada;
    private Integer numeroCreditos;
    private String jornada;
}
