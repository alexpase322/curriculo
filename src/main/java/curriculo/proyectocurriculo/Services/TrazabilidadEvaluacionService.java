package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.CursoRepository;
import curriculo.proyectocurriculo.Repository.TrazabilidadEvaluacionRepository;
import curriculo.proyectocurriculo.dto.TrazabilidadEvaluacionDTO;
import curriculo.proyectocurriculo.models.Curso;
import curriculo.proyectocurriculo.models.TrazabilidadEvaluacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TrazabilidadEvaluacionService {

    private final TrazabilidadEvaluacionRepository trazabilidadEvaluacionRepository;
    private final CursoRepository cursoRepository;

    @Autowired
    public TrazabilidadEvaluacionService(TrazabilidadEvaluacionRepository trazabilidadEvaluacionRepository,
                                         CursoRepository cursoRepository) {
        this.trazabilidadEvaluacionRepository = trazabilidadEvaluacionRepository;
        this.cursoRepository = cursoRepository;
    }

    // Crear o actualizar una trazabilidad de evaluación
    public TrazabilidadEvaluacionDTO guardarTrazabilidad(UUID idCurso, TrazabilidadEvaluacionDTO trazabilidadDTO) {
        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado con ID: " + idCurso));

        TrazabilidadEvaluacion trazabilidad = TrazabilidadEvaluacion.builder()
                .curso(curso)
                .fechaEvaluacion(trazabilidadDTO.getFechaEvaluacion())
                .numeroActa(trazabilidadDTO.getNumeroActa())
                .modificacion(trazabilidadDTO.getModificacion())
                .justificacion(trazabilidadDTO.getJustificacion())
                .responsable(trazabilidadDTO.getResponsable())
                .build();

        TrazabilidadEvaluacion savedTrazabilidad = trazabilidadEvaluacionRepository.save(trazabilidad);

        return mapToDTO(savedTrazabilidad);
    }

    // Buscar trazabilidad por ID
    public Optional<TrazabilidadEvaluacionDTO> buscarPorId(UUID id) {
        return trazabilidadEvaluacionRepository.findById(id).map(this::mapToDTO);
    }

    // Listar todas las trazabilidades
    public List<TrazabilidadEvaluacionDTO> listarTodas() {
        return trazabilidadEvaluacionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Eliminar trazabilidad por ID
    public void eliminarPorId(UUID id) {
        trazabilidadEvaluacionRepository.deleteById(id);
    }

    // Método para mapear entidad a DTO
    private TrazabilidadEvaluacionDTO mapToDTO(TrazabilidadEvaluacion trazabilidad) {
        return TrazabilidadEvaluacionDTO.builder()
                .fechaEvaluacion(trazabilidad.getFechaEvaluacion())
                .numeroActa(trazabilidad.getNumeroActa())
                .modificacion(trazabilidad.getModificacion())
                .justificacion(trazabilidad.getJustificacion())
                .responsable(trazabilidad.getResponsable())
                .build();
    }
}

