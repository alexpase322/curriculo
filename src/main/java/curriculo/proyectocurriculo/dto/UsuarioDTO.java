package curriculo.proyectocurriculo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String nombre;
    private String apellido;
    private String contrasena;
    private String email;
    private String nombreRol;
    private String nombrePrograma;
}

