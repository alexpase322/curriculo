package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.TransicionPlanService;
import curriculo.proyectocurriculo.models.TransicionPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transiciones-plan")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class TransicionPlanController {

    private final TransicionPlanService transicionPlanService;

    @Autowired
    public TransicionPlanController(TransicionPlanService transicionPlanService) {
        this.transicionPlanService = transicionPlanService;
    }

    // Crear o actualizar una transición de plan
    @PostMapping("/{idPrograma}")
    public ResponseEntity<TransicionPlan> crearTransicionPlan(
            @PathVariable UUID idPrograma,
            @RequestBody TransicionPlan transicionPlan) {
        TransicionPlan nuevaTransicion = transicionPlanService
                .guardarTransicionPlan(idPrograma, transicionPlan);
        return ResponseEntity.ok(nuevaTransicion);
    }

    // Buscar una transición de plan por ID
    @GetMapping("/{id}")
    public ResponseEntity<TransicionPlan> obtenerTransicionPorId(@PathVariable UUID id) {
        return transicionPlanService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todas las transiciones de plan
    @GetMapping
    public ResponseEntity<List<TransicionPlan>> listarTodas() {
        return ResponseEntity.ok(transicionPlanService.listarTodas());
    }

    // Eliminar una transición de plan por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTransicionPorId(@PathVariable UUID id) {
        transicionPlanService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

