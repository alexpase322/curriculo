package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.CompetenciaService;
import curriculo.proyectocurriculo.dto.CompetenciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/competencias")
public class CompetenciaController {

    private final CompetenciaService competenciaService;

    @Autowired
    public CompetenciaController(CompetenciaService competenciaService) {
        this.competenciaService = competenciaService;
    }

    // Crear o actualizar una competencia
    @PostMapping("/{idPrograma}")
    public ResponseEntity<CompetenciaDTO> crearCompetencia(@PathVariable UUID idPrograma,
                                                           @RequestBody CompetenciaDTO competenciaDTO) {
        CompetenciaDTO nuevaCompetencia = competenciaService.guardarCompetencia(idPrograma, competenciaDTO);
        return ResponseEntity.ok(nuevaCompetencia);
    }

    // Buscar competencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> obtenerPorId(@PathVariable UUID id) {
        return competenciaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todas las competencias
    @GetMapping
    public ResponseEntity<List<CompetenciaDTO>> listarTodas() {
        return ResponseEntity.ok(competenciaService.listarTodas());
    }

    // Eliminar competencia por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable UUID id) {
        competenciaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

