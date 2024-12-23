package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RolRepository extends JpaRepository<Rol, UUID> {

    Rol findByNombreRol(String nombreRol);
}

