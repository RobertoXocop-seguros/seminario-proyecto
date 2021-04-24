package seminario.serminarioproyecto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import seminario.serminarioproyecto.model.Pais;

public interface PaisRepo extends JpaRepository<Pais,Integer> {
}
