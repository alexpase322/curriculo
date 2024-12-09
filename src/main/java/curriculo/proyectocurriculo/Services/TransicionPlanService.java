package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.ProgramaRepository;
import curriculo.proyectocurriculo.Repository.TransicionPlanRepository;
import curriculo.proyectocurriculo.models.Programa;
import curriculo.proyectocurriculo.models.TransicionPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransicionPlanService {

    private final TransicionPlanRepository transicionPlanRepository;
    private final ProgramaRepository programaRepository;

    @Autowired
    public TransicionPlanService(TransicionPlanRepository transicionPlanRepository,
                                 ProgramaRepository programaRepository) {
        this.transicionPlanRepository = transicionPlanRepository;
        this.programaRepository = programaRepository;
    }

    // Crear o actualizar una transición de plan
    public TransicionPlan guardarTransicionPlan(UUID idPrograma, TransicionPlan transicionPlan) {
        Programa programa = programaRepository.findById(idPrograma)
                .orElseThrow(() -> new IllegalArgumentException("Programa no encontrado con ID: " + idPrograma));
        transicionPlan.setPrograma(programa);
        return transicionPlanRepository.save(transicionPlan);
    }

    // Buscar una transición de plan por ID
    public Optional<TransicionPlan> buscarPorId(UUID id) {
        return transicionPlanRepository.findById(id);
    }

    // Listar todas las transiciones de planes
    public List<TransicionPlan> listarTodas() {
        return transicionPlanRepository.findAll();
    }

    // Eliminar una transición de plan por ID
    public void eliminarPorId(UUID id) {
        transicionPlanRepository.deleteById(id);
    }
}

