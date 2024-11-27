package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.RolService;
import curriculo.proyectocurriculo.Services.UsuarioService;
import curriculo.proyectocurriculo.models.Rol;
import curriculo.proyectocurriculo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final RolService rolService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, RolService rolService) {
        this.usuarioService = usuarioService;
        this.rolService = rolService;
    }

    @GetMapping("/buscar/usuario")
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
        Optional<Usuario> usuarioOpt = Optional.ofNullable(usuarioService.buscarPorEmail(email));

        if (usuarioOpt.isPresent()) {
            return ResponseEntity.ok(usuarioOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/createUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Crear un nuevo rol
    @PostMapping("/createRol")
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.guardarRol(rol);
        return ResponseEntity.ok(nuevoRol);
    }

    // Buscar un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Long id) {
        return rolService.buscarRolPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar un rol por nombre
    @GetMapping("/buscarRol")
    public ResponseEntity<Rol> obtenerRolPorNombre(@RequestParam String nombre) {
        return rolService.buscarRolPorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todos los roles
    @GetMapping("/listaRoles")
    public ResponseEntity<List<Rol>> listarRoles() {
        return ResponseEntity.ok(rolService.listarRoles());
    }

    // Eliminar un rol por ID
    @DeleteMapping("/eliminarRol/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idUsuario}/actualizar-rol/{idRol}")
    public ResponseEntity<Usuario> actualizarRolDeUsuario(@PathVariable Long idUsuario, @PathVariable Long idRol) {
        return usuarioService.actualizarRolDeUsuario(idUsuario, idRol)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
