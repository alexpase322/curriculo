package curriculo.proyectocurriculo.Controller;

import curriculo.proyectocurriculo.Services.CursoService;
import curriculo.proyectocurriculo.models.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cursos")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class CursoController {

    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Crear o actualizar un curso
    @PostMapping("/{idPrograma}")
    public ResponseEntity<Curso> crearCurso(@PathVariable UUID idPrograma, @RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.guardarCurso(idPrograma, curso);
        return ResponseEntity.ok(nuevoCurso);
    }

    // Buscar un curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable UUID id) {
        return cursoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todos los cursos
    @GetMapping
    public ResponseEntity<List<Curso>> listarTodos() {
        return ResponseEntity.ok(cursoService.listarTodos());
    }

    // Eliminar un curso por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCursoPorId(@PathVariable UUID id) {
        cursoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
