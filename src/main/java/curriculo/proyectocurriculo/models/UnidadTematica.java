package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "unidad_tematica")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadTematica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidad;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    private Integer numero;
    private String contenido;
    private String estrategiasDidacticas;
    private Integer horasTeoricas;
    private Integer horasTeoricoPracticas;
    private Integer horasPracticas;
    private Integer horasTrabajoIndependiente;
}

