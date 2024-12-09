package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.OrganizacionCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizacionCurricularRepository extends JpaRepository<OrganizacionCurricular, UUID> {
}

