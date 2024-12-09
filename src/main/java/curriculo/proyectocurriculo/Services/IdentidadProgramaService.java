package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.IdentidadProgramaRepository;
import curriculo.proyectocurriculo.Repository.ProgramaRepository;
import curriculo.proyectocurriculo.models.IdentidadPrograma;
import curriculo.proyectocurriculo.models.Programa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IdentidadProgramaService {

    private final IdentidadProgramaRepository identidadProgramaRepository;
    private final ProgramaRepository programaRepository;

    @Autowired
    public IdentidadProgramaService(IdentidadProgramaRepository identidadProgramaRepository,
                                    ProgramaRepository programaRepository) {
        this.identidadProgramaRepository = identidadProgramaRepository;
        this.programaRepository = programaRepository;
    }

    // Crear o actualizar una identidad de programa
    public IdentidadPrograma guardarIdentidadPrograma(UUID idPrograma, IdentidadPrograma identidadPrograma) {
        Programa programa = programaRepository.findById(idPrograma)
                .orElseThrow(() -> new IllegalArgumentException("Programa no encontrado con ID: " + idPrograma));
        identidadPrograma.setPrograma(programa);
        return identidadProgramaRepository.save(identidadPrograma);
    }

    // Buscar una identidad de programa por ID
    public Optional<IdentidadPrograma> buscarPorId(UUID id) {
        return identidadProgramaRepository.findById(id);
    }

    // Listar todas las identidades de programa
    public List<IdentidadPrograma> listarTodas() {
        return identidadProgramaRepository.findAll();
    }

    // Eliminar una identidad de programa por ID
    public void eliminarPorId(UUID id) {
        identidadProgramaRepository.deleteById(id);
    }
}

