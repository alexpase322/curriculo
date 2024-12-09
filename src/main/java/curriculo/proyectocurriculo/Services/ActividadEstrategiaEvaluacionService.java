package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.ActividadEstrategiaEvaluacionRepository;
import curriculo.proyectocurriculo.Repository.ResultadoAprendizajeRepository;
import curriculo.proyectocurriculo.dto.ActividadEstrategiaEvaluacionDTO;
import curriculo.proyectocurriculo.models.ActividadEstrategiaEvaluacion;
import curriculo.proyectocurriculo.models.ResultadoAprendizaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ActividadEstrategiaEvaluacionService {

    private final ActividadEstrategiaEvaluacionRepository actividadEstrategiaEvaluacionRepository;
    private final ResultadoAprendizajeRepository resultadoAprendizajeRepository;

    @Autowired
    public ActividadEstrategiaEvaluacionService(ActividadEstrategiaEvaluacionRepository actividadEstrategiaEvaluacionRepository,
                                                ResultadoAprendizajeRepository resultadoAprendizajeRepository) {
        this.actividadEstrategiaEvaluacionRepository = actividadEstrategiaEvaluacionRepository;
        this.resultadoAprendizajeRepository = resultadoAprendizajeRepository;
    }

    // Crear o actualizar una actividad estrategia evaluación
    public ActividadEstrategiaEvaluacionDTO guardarActividad(UUID idResultado, ActividadEstrategiaEvaluacionDTO actividadDTO) {
        ResultadoAprendizaje resultadoAprendizaje = resultadoAprendizajeRepository.findById(idResultado)
                .orElseThrow(() -> new IllegalArgumentException("Resultado de aprendizaje no encontrado con ID: " + idResultado));

        ActividadEstrategiaEvaluacion actividad = ActividadEstrategiaEvaluacion.builder()
                .resultadoAprendizaje(resultadoAprendizaje)
                .actividadAcademica(actividadDTO.getActividadAcademica())
                .estrategiaEvaluacion(actividadDTO.getEstrategiaEvaluacion())
                .build();

        ActividadEstrategiaEvaluacion savedActividad = actividadEstrategiaEvaluacionRepository.save(actividad);

        return mapToDTO(savedActividad);
    }

    // Buscar actividad estrategia evaluación por ID
    public Optional<ActividadEstrategiaEvaluacionDTO> buscarPorId(UUID id) {
        return actividadEstrategiaEvaluacionRepository.findById(id).map(this::mapToDTO);
    }

    // Listar todas las actividades estrategias evaluación
    public List<ActividadEstrategiaEvaluacionDTO> listarTodas() {
        return actividadEstrategiaEvaluacionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Eliminar actividad estrategia evaluación por ID
    public void eliminarPorId(UUID id) {
        actividadEstrategiaEvaluacionRepository.deleteById(id);
    }

    // Método para mapear entidad a DTO
    private ActividadEstrategiaEvaluacionDTO mapToDTO(ActividadEstrategiaEvaluacion actividad) {
        return ActividadEstrategiaEvaluacionDTO.builder()
                .actividadAcademica(actividad.getActividadAcademica())
                .estrategiaEvaluacion(actividad.getEstrategiaEvaluacion())
                .build();
    }
}

