package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.ProgramaRepository;
import curriculo.proyectocurriculo.Repository.PropositosYPerfilesRepository;
import curriculo.proyectocurriculo.models.Programa;
import curriculo.proyectocurriculo.models.PropositosYPerfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PropositosYPerfilesService {

    private final PropositosYPerfilesRepository propositosYPerfilesRepository;
    private final ProgramaRepository programaRepository;

    @Autowired
    public PropositosYPerfilesService(PropositosYPerfilesRepository propositosYPerfilesRepository,
                                      ProgramaRepository programaRepository) {
        this.propositosYPerfilesRepository = propositosYPerfilesRepository;
        this.programaRepository = programaRepository;
    }

    // Crear o actualizar propósitos y perfiles
    public PropositosYPerfiles guardarPropositosYPerfiles(UUID idPrograma, PropositosYPerfiles propositosYPerfiles) {
        Programa programa = programaRepository.findById(idPrograma)
                .orElseThrow(() -> new IllegalArgumentException("Programa no encontrado con ID: " + idPrograma));
        propositosYPerfiles.setPrograma(programa);
        return propositosYPerfilesRepository.save(propositosYPerfiles);
    }

    // Buscar propósitos y perfiles por ID
    public Optional<PropositosYPerfiles> buscarPorId(UUID id) {
        return propositosYPerfilesRepository.findById(id);
    }

    // Listar todos los propósitos y perfiles
    public List<PropositosYPerfiles> listarTodos() {
        return propositosYPerfilesRepository.findAll();
    }

    // Eliminar propósitos y perfiles por ID
    public void eliminarPorId(UUID id) {
        propositosYPerfilesRepository.deleteById(id);
    }
}

