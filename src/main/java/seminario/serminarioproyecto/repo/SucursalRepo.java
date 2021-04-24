package seminario.serminarioproyecto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import seminario.serminarioproyecto.model.Sucursal;

import java.util.List;

public interface SucursalRepo extends JpaRepository<Sucursal, Integer> {
    List<Sucursal> getAllByComercio_IdAndMunicipio_Id(Integer idComercio,Integer idMunicipio);
    List<Sucursal> getAllByComercio_Id(Integer idComercio);
}
