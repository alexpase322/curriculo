package curriculo.proyectocurriculo.Repository;

import curriculo.proyectocurriculo.models.PropositosYPerfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PropositosYPerfilesRepository extends JpaRepository<PropositosYPerfiles, UUID  > {
}

