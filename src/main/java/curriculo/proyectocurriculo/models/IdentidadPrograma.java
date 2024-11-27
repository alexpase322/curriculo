package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "identidad_programa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentidadPrograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIdentidad;

    @ManyToOne
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    private String mision;
    private String vision;
    private String resenaHistorica;
    private String conceptualizacionTeorica;
    private String pertinenciaProspectiva;
}


