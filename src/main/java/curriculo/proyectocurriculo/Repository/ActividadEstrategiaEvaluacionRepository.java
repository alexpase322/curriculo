package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.ActividadEstrategiaEvaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ActividadEstrategiaEvaluacionRepository extends JpaRepository<ActividadEstrategiaEvaluacion, UUID> {
}

