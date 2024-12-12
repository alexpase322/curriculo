package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.TrazabilidadEvaluacionService;
import curriculo.proyectocurriculo.dto.TrazabilidadEvaluacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/trazabilidades-evaluacion")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class TrazabilidadEvaluacionController {

    private final TrazabilidadEvaluacionService trazabilidadEvaluacionService;

    @Autowired
    public TrazabilidadEvaluacionController(TrazabilidadEvaluacionService trazabilidadEvaluacionService) {
        this.trazabilidadEvaluacionService = trazabilidadEvaluacionService;
    }

    // Crear o actualizar una trazabilidad de evaluación
    @PostMapping("/{idCurso}")
    public ResponseEntity<TrazabilidadEvaluacionDTO> crearTrazabilidad(@PathVariable UUID idCurso,
                                                                       @RequestBody TrazabilidadEvaluacionDTO trazabilidadDTO) {
        TrazabilidadEvaluacionDTO nuevaTrazabilidad = trazabilidadEvaluacionService.guardarTrazabilidad(idCurso, trazabilidadDTO);
        return ResponseEntity.ok(nuevaTrazabilidad);
    }

    // Buscar trazabilidad por ID
    @GetMapping("/{id}")
    public ResponseEntity<TrazabilidadEvaluacionDTO> obtenerPorId(@PathVariable UUID id) {
        return trazabilidadEvaluacionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todas las trazabilidades
    @GetMapping
    public ResponseEntity<List<TrazabilidadEvaluacionDTO>> listarTodas() {
        return ResponseEntity.ok(trazabilidadEvaluacionService.listarTodas());
    }

    // Eliminar trazabilidad por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable UUID id) {
        trazabilidadEvaluacionService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

