package seminario.serminarioproyecto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import seminario.serminarioproyecto.model.Municipio;

import java.util.List;

public interface MunicipioRepo extends JpaRepository<Municipio, Integer> {

    List<Municipio> getAllByDepartamento_IdOrderByNombre(Integer id);

    List<Municipio> getAllByDepartamento_Pais_Id(Integer idPais);
}
