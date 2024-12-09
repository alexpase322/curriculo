package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.EvaluacionAprendizajeRepository;
import curriculo.proyectocurriculo.Repository.ResultadoAprendizajeRepository;
import curriculo.proyectocurriculo.dto.EvaluacionAprendizajeDTO;
import curriculo.proyectocurriculo.models.EvaluacionAprendizaje;
import curriculo.proyectocurriculo.models.ResultadoAprendizaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EvaluacionAprendizajeService {

    private final EvaluacionAprendizajeRepository evaluacionAprendizajeRepository;
    private final ResultadoAprendizajeRepository resultadoAprendizajeRepository;

    @Autowired
    public EvaluacionAprendizajeService(EvaluacionAprendizajeRepository evaluacionAprendizajeRepository,
                                        ResultadoAprendizajeRepository resultadoAprendizajeRepository) {
        this.evaluacionAprendizajeRepository = evaluacionAprendizajeRepository;
        this.resultadoAprendizajeRepository = resultadoAprendizajeRepository;
    }

    // Crear o actualizar una evaluación de aprendizaje
    public EvaluacionAprendizajeDTO guardarEvaluacion(UUID idResultado, EvaluacionAprendizajeDTO evaluacionDTO) {
        ResultadoAprendizaje resultadoAprendizaje = resultadoAprendizajeRepository.findById(idResultado)
                .orElseThrow(() -> new IllegalArgumentException("Resultado de aprendizaje no encontrado con ID: " + idResultado));

        EvaluacionAprendizaje evaluacion = EvaluacionAprendizaje.builder()
                .resultadoAprendizaje(resultadoAprendizaje)
                .estrategiasEvaluacion(evaluacionDTO.getEstrategiasEvaluacion())
                .actividadesEvaluacion(evaluacionDTO.getActividadesEvaluacion())
                .build();

        EvaluacionAprendizaje savedEvaluacion = evaluacionAprendizajeRepository.save(evaluacion);

        return mapToDTO(savedEvaluacion);
    }

    // Buscar evaluación de aprendizaje por ID
    public Optional<EvaluacionAprendizajeDTO> buscarPorId(UUID id) {
        return evaluacionAprendizajeRepository.findById(id).map(this::mapToDTO);
    }

    // Listar todas las evaluaciones de aprendizaje
    public List<EvaluacionAprendizajeDTO> listarTodas() {
        return evaluacionAprendizajeRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Eliminar evaluación de aprendizaje por ID
    public void eliminarPorId(UUID id) {
        evaluacionAprendizajeRepository.deleteById(id);
    }

    // Método para mapear entidad a DTO
    private EvaluacionAprendizajeDTO mapToDTO(EvaluacionAprendizaje evaluacion) {
        return EvaluacionAprendizajeDTO.builder()
                .estrategiasEvaluacion(evaluacion.getEstrategiasEvaluacion())
                .actividadesEvaluacion(evaluacion.getActividadesEvaluacion())
                .build();
    }
}
