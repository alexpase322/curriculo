package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "identidad_programa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentidadPrograma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idIdentidad;

    @ManyToOne
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    private String mision;
    private String vision;
    private String resenaHistorica;
    private String conceptualizacionTeorica;
    private String pertinenciaProspectiva;
}


