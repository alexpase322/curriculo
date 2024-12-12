package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.ActividadEstrategiaEvaluacionService;
import curriculo.proyectocurriculo.dto.ActividadEstrategiaEvaluacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/actividades-estrategias")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class ActividadEstrategiaEvaluacionController {

    private final ActividadEstrategiaEvaluacionService actividadEstrategiaEvaluacionService;

    @Autowired
    public ActividadEstrategiaEvaluacionController(ActividadEstrategiaEvaluacionService actividadEstrategiaEvaluacionService) {
        this.actividadEstrategiaEvaluacionService = actividadEstrategiaEvaluacionService;
    }

    // Crear o actualizar una actividad estrategia evaluación
    @PostMapping("/{idResultado}")
    public ResponseEntity<ActividadEstrategiaEvaluacionDTO> crearActividad(@PathVariable UUID idResultado,
                                                                           @RequestBody ActividadEstrategiaEvaluacionDTO actividadDTO) {
        ActividadEstrategiaEvaluacionDTO nuevaActividad = actividadEstrategiaEvaluacionService.guardarActividad(idResultado, actividadDTO);
        return ResponseEntity.ok(nuevaActividad);
    }

    // Buscar actividad estrategia evaluación por ID
    @GetMapping("/{id}")
    public ResponseEntity<ActividadEstrategiaEvaluacionDTO> obtenerPorId(@PathVariable UUID id) {
        return actividadEstrategiaEvaluacionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todas las actividades estrategias evaluación
    @GetMapping
    public ResponseEntity<List<ActividadEstrategiaEvaluacionDTO>> listarTodas() {
        return ResponseEntity.ok(actividadEstrategiaEvaluacionService.listarTodas());
    }

    // Eliminar actividad estrategia evaluación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable UUID id) {
        actividadEstrategiaEvaluacionService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

