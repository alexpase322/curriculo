package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.ProcesosMisionalesService;
import curriculo.proyectocurriculo.models.ProcesosMisionales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/procesos-misionales")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class ProcesosMisionalesController {

    private final ProcesosMisionalesService procesosMisionalesService;

    @Autowired
    public ProcesosMisionalesController(ProcesosMisionalesService procesosMisionalesService) {
        this.procesosMisionalesService = procesosMisionalesService;
    }

    // Crear o actualizar procesos misionales
    @PostMapping("/{idPrograma}")
    public ResponseEntity<ProcesosMisionales> crearProcesosMisionales(
            @PathVariable UUID idPrograma,
            @RequestBody ProcesosMisionales procesosMisionales) {
        ProcesosMisionales nuevosProcesos = procesosMisionalesService
                .guardarProcesosMisionales(idPrograma, procesosMisionales);
        return ResponseEntity.ok(nuevosProcesos);
    }

    // Buscar procesos misionales por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProcesosMisionales> obtenerProcesosPorId(@PathVariable UUID id) {
        return procesosMisionalesService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todos los procesos misionales
    @GetMapping
    public ResponseEntity<List<ProcesosMisionales>> listarTodos() {
        return ResponseEntity.ok(procesosMisionalesService.listarTodos());
    }

    // Eliminar procesos misionales por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProcesosPorId(@PathVariable UUID id) {
        procesosMisionalesService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

