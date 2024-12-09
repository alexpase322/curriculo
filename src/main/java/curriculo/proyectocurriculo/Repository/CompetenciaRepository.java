package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, UUID> {
}

