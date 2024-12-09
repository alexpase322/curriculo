package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.EvaluacionAprendizajeService;
import curriculo.proyectocurriculo.dto.EvaluacionAprendizajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/evaluaciones-aprendizaje")
public class EvaluacionAprendizajeController {

    private final EvaluacionAprendizajeService evaluacionAprendizajeService;

    @Autowired
    public EvaluacionAprendizajeController(EvaluacionAprendizajeService evaluacionAprendizajeService) {
        this.evaluacionAprendizajeService = evaluacionAprendizajeService;
    }

    // Crear o actualizar una evaluación de aprendizaje
    @PostMapping("/{idResultado}")
    public ResponseEntity<EvaluacionAprendizajeDTO> crearEvaluacion(@PathVariable UUID idResultado,
                                                                    @RequestBody EvaluacionAprendizajeDTO evaluacionDTO) {
        EvaluacionAprendizajeDTO nuevaEvaluacion = evaluacionAprendizajeService.guardarEvaluacion(idResultado, evaluacionDTO);
        return ResponseEntity.ok(nuevaEvaluacion);
    }

    // Buscar evaluación de aprendizaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionAprendizajeDTO> obtenerPorId(@PathVariable UUID id) {
        return evaluacionAprendizajeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todas las evaluaciones de aprendizaje
    @GetMapping
    public ResponseEntity<List<EvaluacionAprendizajeDTO>> listarTodas() {
        return ResponseEntity.ok(evaluacionAprendizajeService.listarTodas());
    }

    // Eliminar evaluación de aprendizaje por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable UUID id) {
        evaluacionAprendizajeService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

