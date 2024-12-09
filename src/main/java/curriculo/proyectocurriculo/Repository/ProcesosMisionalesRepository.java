package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.ProcesosMisionales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProcesosMisionalesRepository extends JpaRepository<ProcesosMisionales, UUID> {
}

