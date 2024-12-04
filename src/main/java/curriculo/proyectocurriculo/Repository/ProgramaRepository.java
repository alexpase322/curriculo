package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, UUID> {
    Programa findProgramaByNombrePrograma(String nombrePrograma);
}
