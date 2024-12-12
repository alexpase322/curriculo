package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.PropositosYPerfilesService;
import curriculo.proyectocurriculo.models.PropositosYPerfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/propositos-y-perfiles")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class PropositosYPerfilesController {

    private final PropositosYPerfilesService propositosYPerfilesService;

    @Autowired
    public PropositosYPerfilesController(PropositosYPerfilesService propositosYPerfilesService) {
        this.propositosYPerfilesService = propositosYPerfilesService;
    }

    // Crear o actualizar propósitos y perfiles
    @PostMapping("/{idPrograma}")
    public ResponseEntity<PropositosYPerfiles> crearPropositosYPerfiles(
            @PathVariable UUID idPrograma,
            @RequestBody PropositosYPerfiles propositosYPerfiles) {
        PropositosYPerfiles nuevosPropositos = propositosYPerfilesService
                .guardarPropositosYPerfiles(idPrograma, propositosYPerfiles);
        return ResponseEntity.ok(nuevosPropositos);
    }

    // Buscar propósitos y perfiles por ID
    @GetMapping("/{id}")
    public ResponseEntity<PropositosYPerfiles> obtenerPorId(@PathVariable UUID id) {
        return propositosYPerfilesService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todos los propósitos y perfiles
    @GetMapping
    public ResponseEntity<List<PropositosYPerfiles>> listarTodos() {
        return ResponseEntity.ok(propositosYPerfilesService.listarTodos());
    }

    // Eliminar propósitos y perfiles por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable UUID id) {
        propositosYPerfilesService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
