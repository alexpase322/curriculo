package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.ResultadoAprendizajeService;
import curriculo.proyectocurriculo.dto.ResultadoAprendizajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/resultados-aprendizaje")
public class ResultadoAprendizajeController {

    private final ResultadoAprendizajeService resultadoAprendizajeService;

    @Autowired
    public ResultadoAprendizajeController(ResultadoAprendizajeService resultadoAprendizajeService) {
        this.resultadoAprendizajeService = resultadoAprendizajeService;
    }

    // Crear o actualizar un resultado de aprendizaje
    @PostMapping("/{idCompetencia}")
    public ResponseEntity<ResultadoAprendizajeDTO> crearResultado(@PathVariable UUID idCompetencia,
                                                                  @RequestBody ResultadoAprendizajeDTO resultadoDTO) {
        ResultadoAprendizajeDTO nuevoResultado = resultadoAprendizajeService.guardarResultado(idCompetencia, resultadoDTO);
        return ResponseEntity.ok(nuevoResultado);
    }

    // Buscar resultado de aprendizaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<ResultadoAprendizajeDTO> obtenerPorId(@PathVariable UUID id) {
        return resultadoAprendizajeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todos los resultados de aprendizaje
    @GetMapping
    public ResponseEntity<List<ResultadoAprendizajeDTO>> listarTodos() {
        return ResponseEntity.ok(resultadoAprendizajeService.listarTodos());
    }

    // Eliminar resultado de aprendizaje por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable UUID id) {
        resultadoAprendizajeService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

