package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.ProcesosMisionalesRepository;
import curriculo.proyectocurriculo.Repository.ProgramaRepository;
import curriculo.proyectocurriculo.models.ProcesosMisionales;
import curriculo.proyectocurriculo.models.Programa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProcesosMisionalesService {

    private final ProcesosMisionalesRepository procesosMisionalesRepository;
    private final ProgramaRepository programaRepository;

    @Autowired
    public ProcesosMisionalesService(ProcesosMisionalesRepository procesosMisionalesRepository,
                                     ProgramaRepository programaRepository) {
        this.procesosMisionalesRepository = procesosMisionalesRepository;
        this.programaRepository = programaRepository;
    }

    // Crear o actualizar procesos misionales
    public ProcesosMisionales guardarProcesosMisionales(UUID idPrograma, ProcesosMisionales procesosMisionales) {
        Programa programa = programaRepository.findById(idPrograma)
                .orElseThrow(() -> new IllegalArgumentException("Programa no encontrado con ID: " + idPrograma));
        procesosMisionales.setPrograma(programa);
        return procesosMisionalesRepository.save(procesosMisionales);
    }

    // Buscar procesos misionales por ID
    public Optional<ProcesosMisionales> buscarPorId(UUID id) {
        return procesosMisionalesRepository.findById(id);
    }

    // Listar todos los procesos misionales
    public List<ProcesosMisionales> listarTodos() {
        return procesosMisionalesRepository.findAll();
    }

    // Eliminar procesos misionales por ID
    public void eliminarPorId(UUID id) {
        procesosMisionalesRepository.deleteById(id);
    }
}

