package seminario.serminarioproyecto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import seminario.serminarioproyecto.model.Region;

public interface RegionRepo extends JpaRepository<Region,Integer> {
}
