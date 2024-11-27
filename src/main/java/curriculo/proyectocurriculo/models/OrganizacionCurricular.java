package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "organizacion_curricular")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrganizacion;

    @ManyToOne
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    private String estructuraBasica;
    private String estructuraComplementaria;
    private Integer totalCreditos;
}

