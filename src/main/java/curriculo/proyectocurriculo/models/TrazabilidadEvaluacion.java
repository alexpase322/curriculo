package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "trazabilidad_evaluacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrazabilidadEvaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTrazabilidad;

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

