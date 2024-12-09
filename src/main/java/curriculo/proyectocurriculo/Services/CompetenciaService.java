package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.CompetenciaRepository;
import curriculo.proyectocurriculo.Repository.ProgramaRepository;
import curriculo.proyectocurriculo.dto.CompetenciaDTO;
import curriculo.proyectocurriculo.models.Competencia;
import curriculo.proyectocurriculo.models.Programa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;
    private final ProgramaRepository programaRepository;

    @Autowired
    public CompetenciaService(CompetenciaRepository competenciaRepository, ProgramaRepository programaRepository) {
        this.competenciaRepository = competenciaRepository;
        this.programaRepository = programaRepository;
    }

    // Crear o actualizar una competencia
    public CompetenciaDTO guardarCompetencia(UUID idPrograma, CompetenciaDTO competenciaDTO) {
        Programa programa = programaRepository.findById(idPrograma)
                .orElseThrow(() -> new IllegalArgumentException("Programa no encontrado con ID: " + idPrograma));

        Competencia competencia = Competencia.builder()
                .programa(programa)
                .descripcion(competenciaDTO.getDescripcion())
                .build();

        Competencia savedCompetencia = competenciaRepository.save(competencia);

        return mapToDTO(savedCompetencia);
    }

    // Buscar competencia por ID
    public Optional<CompetenciaDTO> buscarPorId(UUID id) {
        return competenciaRepository.findById(id).map(this::mapToDTO);
    }

    // Listar todas las competencias
    public List<CompetenciaDTO> listarTodas() {
        return competenciaRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Eliminar competencia por ID
    public void eliminarPorId(UUID id) {
        competenciaRepository.deleteById(id);
    }

    // Método para mapear entidad a DTO
    private CompetenciaDTO mapToDTO(Competencia competencia) {
        return CompetenciaDTO.builder()
                .descripcion(competencia.getDescripcion())
                .build();
    }
}

