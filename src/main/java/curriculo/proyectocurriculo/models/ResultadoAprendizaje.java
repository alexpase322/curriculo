package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "resultado_aprendizaje")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultadoAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idResultado;

    @ManyToOne
    @JoinColumn(name = "id_competencia", nullable = false)
    private Competencia competencia;

    private String descripcion;
}


