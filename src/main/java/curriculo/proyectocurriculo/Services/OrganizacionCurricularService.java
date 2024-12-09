package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.OrganizacionCurricularRepository;
import curriculo.proyectocurriculo.Repository.ProgramaRepository;
import curriculo.proyectocurriculo.models.OrganizacionCurricular;
import curriculo.proyectocurriculo.models.Programa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizacionCurricularService {

    private final OrganizacionCurricularRepository organizacionCurricularRepository;
    private final ProgramaRepository programaRepository;

    @Autowired
    public OrganizacionCurricularService(OrganizacionCurricularRepository organizacionCurricularRepository,
                                         ProgramaRepository programaRepository) {
        this.organizacionCurricularRepository = organizacionCurricularRepository;
        this.programaRepository = programaRepository;
    }

    // Crear o actualizar una organización curricular
    public OrganizacionCurricular guardarOrganizacionCurricular(UUID idPrograma, OrganizacionCurricular organizacionCurricular) {
        Programa programa = programaRepository.findById(idPrograma)
                .orElseThrow(() -> new IllegalArgumentException("Programa no encontrado con ID: " + idPrograma));
        organizacionCurricular.setPrograma(programa);
        return organizacionCurricularRepository.save(organizacionCurricular);
    }

    // Buscar una organización curricular por ID
    public Optional<OrganizacionCurricular> buscarPorId(UUID id) {
        return organizacionCurricularRepository.findById(id);
    }

    // Listar todas las organizaciones curriculares
    public List<OrganizacionCurricular> listarTodas() {
        return organizacionCurricularRepository.findAll();
    }

    // Eliminar una organización curricular por ID
    public void eliminarPorId(UUID id) {
        organizacionCurricularRepository.deleteById(id);
    }
}

