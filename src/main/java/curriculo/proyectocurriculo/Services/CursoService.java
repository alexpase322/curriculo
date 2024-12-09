package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.CursoRepository;
import curriculo.proyectocurriculo.Repository.ProgramaRepository;
import curriculo.proyectocurriculo.models.Curso;
import curriculo.proyectocurriculo.models.Programa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final ProgramaRepository programaRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository, ProgramaRepository programaRepository) {
        this.cursoRepository = cursoRepository;
        this.programaRepository = programaRepository;
    }

    // Crear o actualizar un curso
    public Curso guardarCurso(UUID idPrograma, Curso curso) {
        Programa programa = programaRepository.findById(idPrograma)
                .orElseThrow(() -> new IllegalArgumentException("Programa no encontrado con ID: " + idPrograma));
        curso.setPrograma(programa);
        return cursoRepository.save(curso);
    }

    // Buscar un curso por ID
    public Optional<Curso> buscarPorId(UUID id) {
        return cursoRepository.findById(id);
    }

    // Listar todos los cursos
    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    // Eliminar un curso por ID
    public void eliminarPorId(UUID id) {
        cursoRepository.deleteById(id);
    }
}

