package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "organizacion_curricular")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idOrganizacion;

    @ManyToOne
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    private String estructuraBasica;
    private String estructuraComplementaria;
    private Integer totalCreditos;
}

