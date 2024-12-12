package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.IdentidadProgramaService;
import curriculo.proyectocurriculo.models.IdentidadPrograma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/identidades-programas")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class IdentidadProgramaController {

    private final IdentidadProgramaService identidadProgramaService;

    @Autowired
    public IdentidadProgramaController(IdentidadProgramaService identidadProgramaService) {
        this.identidadProgramaService = identidadProgramaService;
    }

    // Crear o actualizar una identidad de programa
    @PostMapping("/{idPrograma}")
    public ResponseEntity<IdentidadPrograma> crearIdentidadPrograma(
            @PathVariable UUID idPrograma,
            @RequestBody IdentidadPrograma identidadPrograma) {
        IdentidadPrograma nuevaIdentidad = identidadProgramaService
                .guardarIdentidadPrograma(idPrograma, identidadPrograma);
        return ResponseEntity.ok(nuevaIdentidad);
    }

    // Buscar una identidad de programa por ID
    @GetMapping("/{id}")
    public ResponseEntity<IdentidadPrograma> obtenerIdentidadPorId(@PathVariable UUID id) {
        return identidadProgramaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todas las identidades de programa
    @GetMapping
    public ResponseEntity<List<IdentidadPrograma>> listarTodas() {
        return ResponseEntity.ok(identidadProgramaService.listarTodas());
    }

    // Eliminar una identidad de programa por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarIdentidadPorId(@PathVariable UUID id) {
        identidadProgramaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
