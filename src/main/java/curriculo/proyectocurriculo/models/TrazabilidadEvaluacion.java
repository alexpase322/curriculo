package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trazabilidad_evaluacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrazabilidadEvaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrazabilidad;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    private String numeroActa;
    private String modificacion;
    private String justificacion;
    private String responsable;

    @Temporal(TemporalType.DATE)
    private java.util.Date fechaEvaluacion;
}

