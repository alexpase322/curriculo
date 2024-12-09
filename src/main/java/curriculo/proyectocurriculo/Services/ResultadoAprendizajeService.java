package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.CompetenciaRepository;
import curriculo.proyectocurriculo.Repository.ResultadoAprendizajeRepository;
import curriculo.proyectocurriculo.dto.ResultadoAprendizajeDTO;
import curriculo.proyectocurriculo.models.Competencia;
import curriculo.proyectocurriculo.models.ResultadoAprendizaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ResultadoAprendizajeService {

    private final ResultadoAprendizajeRepository resultadoAprendizajeRepository;
    private final CompetenciaRepository competenciaRepository;

    @Autowired
    public ResultadoAprendizajeService(ResultadoAprendizajeRepository resultadoAprendizajeRepository,
                                       CompetenciaRepository competenciaRepository) {
        this.resultadoAprendizajeRepository = resultadoAprendizajeRepository;
        this.competenciaRepository = competenciaRepository;
    }

    // Crear o actualizar un resultado de aprendizaje
    public ResultadoAprendizajeDTO guardarResultado(UUID idCompetencia, ResultadoAprendizajeDTO resultadoDTO) {
        Competencia competencia = competenciaRepository.findById(idCompetencia)
                .orElseThrow(() -> new IllegalArgumentException("Competencia no encontrada con ID: " + idCompetencia));

        ResultadoAprendizaje resultadoAprendizaje = ResultadoAprendizaje.builder()
                .competencia(competencia)
                .descripcion(resultadoDTO.getDescripcion())
                .build();

        ResultadoAprendizaje savedResultado = resultadoAprendizajeRepository.save(resultadoAprendizaje);

        return mapToDTO(savedResultado);
    }

    // Buscar resultado de aprendizaje por ID
    public Optional<ResultadoAprendizajeDTO> buscarPorId(UUID id) {
        return resultadoAprendizajeRepository.findById(id).map(this::mapToDTO);
    }

    // Listar todos los resultados de aprendizaje
    public List<ResultadoAprendizajeDTO> listarTodos() {
        return resultadoAprendizajeRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Eliminar resultado de aprendizaje por ID
    public void eliminarPorId(UUID id) {
        resultadoAprendizajeRepository.deleteById(id);
    }

    // Método para mapear entidad a DTO
    private ResultadoAprendizajeDTO mapToDTO(ResultadoAprendizaje resultado) {
        return ResultadoAprendizajeDTO.builder()
                .descripcion(resultado.getDescripcion())
                .build();
    }
}
