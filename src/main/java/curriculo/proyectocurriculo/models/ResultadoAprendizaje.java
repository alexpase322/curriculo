package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resultado_aprendizaje")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResultado;

    @ManyToOne
    @JoinColumn(name = "id_competencia", nullable = false)
    private Competencia competencia;

    private String descripcion;
}

