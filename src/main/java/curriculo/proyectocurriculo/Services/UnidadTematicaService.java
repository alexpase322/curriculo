package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.CursoRepository;
import curriculo.proyectocurriculo.Repository.UnidadTematicaRepository;
import curriculo.proyectocurriculo.dto.UnidadTematicaDTO;
import curriculo.proyectocurriculo.models.Curso;
import curriculo.proyectocurriculo.models.UnidadTematica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UnidadTematicaService {

    private final UnidadTematicaRepository unidadTematicaRepository;
    private final CursoRepository cursoRepository;

    @Autowired
    public UnidadTematicaService(UnidadTematicaRepository unidadTematicaRepository, CursoRepository cursoRepository) {
        this.unidadTematicaRepository = unidadTematicaRepository;
        this.cursoRepository = cursoRepository;
    }

    // Crear o actualizar una unidad temática
    public UnidadTematicaDTO guardarUnidadTematica(UUID idCurso, UnidadTematicaDTO unidadTematicaDTO) {
        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado con ID: " + idCurso));

        UnidadTematica unidadTematica = UnidadTematica.builder()
                .curso(curso)
                .numero(unidadTematicaDTO.getNumero())
                .contenido(unidadTematicaDTO.getContenido())
                .estrategiasDidacticas(unidadTematicaDTO.getEstrategiasDidacticas())
                .horasTeoricas(unidadTematicaDTO.getHorasTeoricas())
                .horasTeoricoPracticas(unidadTematicaDTO.getHorasTeoricoPracticas())
                .horasPracticas(unidadTematicaDTO.getHorasPracticas())
                .horasTrabajoIndependiente(unidadTematicaDTO.getHorasTrabajoIndependiente())
                .build();

        UnidadTematica savedUnidad = unidadTematicaRepository.save(unidadTematica);

        return mapToDTO(savedUnidad);
    }

    // Buscar una unidad temática por ID
    public Optional<UnidadTematicaDTO> buscarPorId(UUID id) {
        return unidadTematicaRepository.findById(id).map(this::mapToDTO);
    }

    // Listar todas las unidades temáticas
    public List<UnidadTematicaDTO> listarTodas() {
        return unidadTematicaRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Eliminar una unidad temática por ID
    public void eliminarPorId(UUID id) {
        unidadTematicaRepository.deleteById(id);
    }

    // Metodo para mapear una entidad a DTO
    private UnidadTematicaDTO mapToDTO(UnidadTematica unidadTematica) {
        return UnidadTematicaDTO.builder()
                .numero(unidadTematica.getNumero())
                .contenido(unidadTematica.getContenido())
                .estrategiasDidacticas(unidadTematica.getEstrategiasDidacticas())
                .horasTeoricas(unidadTematica.getHorasTeoricas())
                .horasTeoricoPracticas(unidadTematica.getHorasTeoricoPracticas())
                .horasPracticas(unidadTematica.getHorasPracticas())
                .horasTrabajoIndependiente(unidadTematica.getHorasTrabajoIndependiente())
                .build();
    }
}

