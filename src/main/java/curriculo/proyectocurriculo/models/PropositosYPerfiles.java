package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "propositos_y_perfiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropositosYPerfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPropPerfil;

    @ManyToOne
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    private String propositosFormativos;
    private String perfilAspirante;
    private String perfilEgreso;
    private String perfilOcupacional;
}


