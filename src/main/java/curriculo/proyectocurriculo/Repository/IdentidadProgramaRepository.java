package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.IdentidadPrograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IdentidadProgramaRepository extends JpaRepository<IdentidadPrograma, UUID> {
}

