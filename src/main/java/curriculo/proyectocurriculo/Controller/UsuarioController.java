package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.ProgramaService;
import curriculo.proyectocurriculo.Services.RolService;
import curriculo.proyectocurriculo.Services.UsuarioService;
import curriculo.proyectocurriculo.dto.ProgramaDTO;
import curriculo.proyectocurriculo.dto.UsuarioDTO;
import curriculo.proyectocurriculo.models.Programa;
import curriculo.proyectocurriculo.models.Rol;
import curriculo.proyectocurriculo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
@PreAuthorize("hasRole('ADMIN')")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final RolService rolService;
    private final ProgramaService programaService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, RolService rolService, ProgramaService programaService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.rolService = rolService;
        this.programaService = programaService;
        this.passwordEncoder = passwordEncoder;
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
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioDTO usuario) {
        Usuario nuevoUsuario = Usuario.builder()
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .email(usuario.getEmail())
                .contrasena(passwordEncoder.encode(usuario.getContrasena()))
                .rol(rolService.buscarRolPorNombre(usuario.getNombreRol()))
                .programa(programaService.findProgramaByName(usuario.getNombrePrograma()))
                .build();
        usuarioService.guardarUsuario(nuevoUsuario);
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
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable UUID id) {
        return rolService.buscarRolPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar un rol por nombre
    @GetMapping("/buscarRol")
    public ResponseEntity<Rol> obtenerRolPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(rolService.buscarRolPorNombre(nombre));
    }

    // Listar todos los roles
    @GetMapping("/listaRoles")
    public ResponseEntity<List<Rol>> listarRoles() {
        return ResponseEntity.ok(rolService.listarRoles());
    }

    // Eliminar un rol por ID
    @DeleteMapping("/eliminarRol/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable UUID id) {
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idUsuario}/actualizar-rol/{idRol}")
    public ResponseEntity<Usuario> actualizarRolDeUsuario(@PathVariable Long idUsuario, @PathVariable UUID idRol) {
        return usuarioService.actualizarRolDeUsuario(idUsuario, idRol)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/programa/all_programas")
    public ResponseEntity<List<Programa>> listarProgramas() {
        return ResponseEntity.ok(programaService.getAllProgramas());
    }

    @PostMapping(value = "/programa/create", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Programa> crearPrograma(@RequestBody ProgramaDTO programa) {
        Programa programaCreated = Programa.builder()
                .nombrePrograma(programa.getNombrePrograma())
                .jornada(programa.getJornada())
                .modalidad(programa.getModalidad())
                .duracionEstimada(programa.getDuracionEstimada())
                .nivelFormacion(programa.getNivelFormacion())
                .numeroCreditos(programa.getNumeroCreditos())
                .tituloOtorgado(programa.getTituloOtorgado())
                .build();
        return ResponseEntity.ok(programaService.crearPrograma(programaCreated));
    }

    @PutMapping(value = "/programa/edit/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Programa> editarPrograma(@RequestParam UUID idPrograma, @RequestBody ProgramaDTO programaEdit) {
        Programa programaFound = programaService.getPrograma(idPrograma);
        programaFound.setNombrePrograma(programaEdit.getNombrePrograma());
        programaFound.setJornada(programaEdit.getJornada());
        programaFound.setModalidad(programaEdit.getModalidad());
        programaFound.setNumeroCreditos(programaEdit.getNumeroCreditos());
        programaFound.setTituloOtorgado(programaEdit.getTituloOtorgado());
        programaFound.setDuracionEstimada(programaEdit.getDuracionEstimada());
        programaFound.setNivelFormacion(programaEdit.getNivelFormacion());
        return ResponseEntity.ok(programaService.actualizarPrograma(programaFound));
    }

    @DeleteMapping(value = "/delete/programa")
    public void eliminarPrograma(@RequestParam UUID idPrograma) {
        programaService.eliminarProgramaById(idPrograma);
    }


}
