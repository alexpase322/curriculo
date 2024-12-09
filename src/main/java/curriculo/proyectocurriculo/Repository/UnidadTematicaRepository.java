package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.UnidadTematica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UnidadTematicaRepository extends JpaRepository<UnidadTematica, UUID> {
}

