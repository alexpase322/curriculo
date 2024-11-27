package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Programa")
@Entity
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrograma;

    private String nombrePrograma;
    private String tituloOtorgado;
    private String nivelFormacion;
    private String modalidad;
    private String duracionEstimada;
    private Integer numeroCreditos;
    private String jornada;
    // Getters y Setters
}

