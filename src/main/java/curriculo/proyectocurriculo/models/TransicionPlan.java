package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "transicion_plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransicionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTransicion;

    @ManyToOne
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    private String descripcionTransicion;
}

