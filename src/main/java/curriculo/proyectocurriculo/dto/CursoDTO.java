package curriculo.proyectocurriculo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursoDTO {
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
}
