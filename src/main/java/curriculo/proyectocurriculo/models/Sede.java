package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sede")
public class Sede {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sedeId;
    private String ciudadSede;
    private String direccionSede;
    private String numeroSede;
    private String emailSede;

    @ManyToOne
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;
}
