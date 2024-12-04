package curriculo.proyectocurriculo.Services;

import curriculo.proyectocurriculo.Repository.RolRepository;
import curriculo.proyectocurriculo.Repository.UsuarioRepository;
import curriculo.proyectocurriculo.models.Rol;
import curriculo.proyectocurriculo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> actualizarRolDeUsuario(Long idUsuario, UUID idRol) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        Optional<Rol> rolOpt = rolRepository.findById(idRol);

        if (usuarioOpt.isPresent() && rolOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            Rol rol = rolOpt.get();
            usuario.setRol(rol); // Actualizar el rol
            return Optional.of(usuarioRepository.save(usuario)); // Guardar cambios
        }

        return Optional.empty(); // Usuario o rol no encontrados
    }
}

