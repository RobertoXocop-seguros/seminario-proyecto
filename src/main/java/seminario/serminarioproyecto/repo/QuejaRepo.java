package seminario.serminarioproyecto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import seminario.serminarioproyecto.dto.ResultDTO;
import seminario.serminarioproyecto.model.Queja;

import java.util.List;

public interface QuejaRepo extends JpaRepository<Queja, Integer> {

    @Query(name = "quejasPorComercio", nativeQuery = true)
    List<ResultDTO> quejasPorComercio();

    @Query(name = "quejasPorMunicipio", nativeQuery = true)
    List<ResultDTO> quejasPorMunicipio();

    @Query(name = "quejasPorDepartamento", nativeQuery = true)
    List<ResultDTO> quejasPorDepartamento();

    @Query(name = "quejasPorRegion", nativeQuery = true)
    List<ResultDTO> quejasPorRegion();
}
