package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.TransicionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransicionPlanRepository extends JpaRepository<TransicionPlan, UUID> {
}

