package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Programa")
@Entity
@Builder
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPrograma;

    private String nombrePrograma;
    private String tituloOtorgado;
    private String nivelFormacion;
    private String modalidad;
    private String duracionEstimada;
    private Integer numeroCreditos;
    private String jornada;

}

