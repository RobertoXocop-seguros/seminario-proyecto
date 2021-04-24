package seminario.serminarioproyecto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import seminario.serminarioproyecto.model.Comercio;

public interface ComercioRepo extends JpaRepository<Comercio, Integer> {
}
