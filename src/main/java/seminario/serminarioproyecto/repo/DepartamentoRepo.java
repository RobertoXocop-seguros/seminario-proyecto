package seminario.serminarioproyecto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import seminario.serminarioproyecto.model.Departamento;

import java.util.List;

public interface DepartamentoRepo extends JpaRepository<Departamento, Integer> {
    @Query(value = "From Departamento c where c.pais.id=:id")
    List<Departamento> getDepartamentoByPais(@Param("id") Integer id);
}
