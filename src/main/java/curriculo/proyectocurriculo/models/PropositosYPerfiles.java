package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "propositos_y_perfiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropositosYPerfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPropPerfil;

    @ManyToOne
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    private String propositosFormativos;
    private String perfilAspirante;
    private String perfilEgreso;
    private String perfilOcupacional;
}


