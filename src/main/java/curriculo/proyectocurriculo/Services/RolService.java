package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.RolRepository;
import curriculo.proyectocurriculo.models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    // Guardar un nuevo rol
    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    // Buscar un rol por su ID
    public Optional<Rol> buscarRolPorId(UUID id) {
        return rolRepository.findById(id);
    }

    // Buscar un rol por su nombre
    public Rol buscarRolPorNombre(String nombreRol) {
        return rolRepository.findByNombreRol(nombreRol);
    }

    // Listar todos los roles
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    // Eliminar un rol por su ID
    public void eliminarRol(UUID id) {
        rolRepository.deleteById(id);
    }
}

