package curriculo.proyectocurriculo.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "procesos_misionales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcesosMisionales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProceso;

    @ManyToOne
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    private String procesoFormativo;
    private String procesoInvestigacion;
    private String procesoProyeccionSocial;
    private String procesoInternacionalizacion;
}

