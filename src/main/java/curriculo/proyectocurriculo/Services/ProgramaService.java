package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.ProgramaRepository;
import curriculo.proyectocurriculo.models.Programa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProgramaService {
    private final ProgramaRepository programaRepository;

    @Autowired
    public ProgramaService(ProgramaRepository programaRepository) {
        this.programaRepository = programaRepository;
    }

    public Programa crearPrograma(Programa programa) {
        return programaRepository.save(programa);
    }

    public Programa getPrograma(UUID id) {
        return programaRepository.findById(id).orElse(null);
    }

    public List<Programa> getAllProgramas() {
        return programaRepository.findAll();
    }

    public Programa guardarPrograma(Programa programa) {
        return programaRepository.save(programa);
    }

    public void eliminarProgramaById(UUID id) {
        programaRepository.deleteById(id);
    }

    public Programa actualizarPrograma(Programa programa) {
        return programaRepository.save(programa);
    }

    public Programa findProgramaByName(String name) {
        return programaRepository.findProgramaByNombrePrograma(name);
    }
}
