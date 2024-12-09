package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.EvaluacionAprendizaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EvaluacionAprendizajeRepository extends JpaRepository<EvaluacionAprendizaje, UUID> {
}

