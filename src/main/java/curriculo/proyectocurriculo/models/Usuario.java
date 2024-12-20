package curriculo.proyectocurriculo.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUsuario;

    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_programa")
    private Programa programa;

    public Optional<ResponseEntity<Object>> map(Object o) {
        return Optional.empty();
    }
}
