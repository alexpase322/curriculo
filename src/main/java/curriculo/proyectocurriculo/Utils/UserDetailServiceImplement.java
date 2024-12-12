package curriculo.proyectocurriculo.Utils;

import curriculo.proyectocurriculo.Repository.UsuarioRepository;
import curriculo.proyectocurriculo.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


@Service
public class UserDetailServiceImplement implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario userEntity =  usuarioRepository.findByEmail(username);
        if(userEntity==null){
            return (UserDetails) new UsernameNotFoundException("El usuario "+ username+ " no existe");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        String role = String.valueOf(userEntity.getRol());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        return new User(userEntity.getEmail(), userEntity.getContrasena(), true, true, true, true,
                authorities);
    }
}
