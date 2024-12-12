package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.UnidadTematicaService;
import curriculo.proyectocurriculo.dto.UnidadTematicaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/unidades-tematicas")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class UnidadTematicaController {

    private final UnidadTematicaService unidadTematicaService;

    @Autowired
    public UnidadTematicaController(UnidadTematicaService unidadTematicaService) {
        this.unidadTematicaService = unidadTematicaService;
    }

    // Crear o actualizar una unidad temática
    @PostMapping("/{idCurso}")
    public ResponseEntity<UnidadTematicaDTO> crearUnidadTematica(@PathVariable UUID idCurso,
                                                                 @RequestBody UnidadTematicaDTO unidadTematicaDTO) {
        UnidadTematicaDTO nuevaUnidad = unidadTematicaService.guardarUnidadTematica(idCurso, unidadTematicaDTO);
        return ResponseEntity.ok(nuevaUnidad);
    }

    // Buscar una unidad temática por ID
    @GetMapping("/{id}")
    public ResponseEntity<UnidadTematicaDTO> obtenerUnidadPorId(@PathVariable UUID id) {
        return unidadTematicaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todas las unidades temáticas
    @GetMapping
    public ResponseEntity<List<UnidadTematicaDTO>> listarTodas() {
        return ResponseEntity.ok(unidadTematicaService.listarTodas());
    }

    // Eliminar una unidad temática por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUnidadPorId(@PathVariable UUID id) {
        unidadTematicaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}


