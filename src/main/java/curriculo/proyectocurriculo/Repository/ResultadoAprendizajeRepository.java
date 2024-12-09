package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.ResultadoAprendizaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResultadoAprendizajeRepository extends JpaRepository<ResultadoAprendizaje, UUID> {
}

