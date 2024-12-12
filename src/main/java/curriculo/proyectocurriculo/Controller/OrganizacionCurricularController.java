package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.OrganizacionCurricularService;
import curriculo.proyectocurriculo.models.OrganizacionCurricular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/organizaciones-curriculares")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class OrganizacionCurricularController {

    private final OrganizacionCurricularService organizacionCurricularService;

    @Autowired
    public OrganizacionCurricularController(OrganizacionCurricularService organizacionCurricularService) {
        this.organizacionCurricularService = organizacionCurricularService;
    }

    // Crear o actualizar una organización curricular
    @PostMapping("/{idPrograma}")
    public ResponseEntity<OrganizacionCurricular> crearOrganizacionCurricular(
            @PathVariable UUID idPrograma,
            @RequestBody OrganizacionCurricular organizacionCurricular) {
        OrganizacionCurricular nuevaOrganizacion = organizacionCurricularService
                .guardarOrganizacionCurricular(idPrograma, organizacionCurricular);
        return ResponseEntity.ok(nuevaOrganizacion);
    }

    // Buscar una organización curricular por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrganizacionCurricular> obtenerOrganizacionPorId(@PathVariable UUID id) {
        return organizacionCurricularService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todas las organizaciones curriculares
    @GetMapping
    public ResponseEntity<List<OrganizacionCurricular>> listarTodas() {
        return ResponseEntity.ok(organizacionCurricularService.listarTodas());
    }

    // Eliminar una organización curricular por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrganizacionPorId(@PathVariable UUID id) {
        organizacionCurricularService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

