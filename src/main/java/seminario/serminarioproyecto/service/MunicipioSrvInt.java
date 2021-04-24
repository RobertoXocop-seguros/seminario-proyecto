package seminario.serminarioproyecto.service;

import seminario.serminarioproyecto.model.Municipio;

import java.util.List;

public interface MunicipioSrvInt extends ICRUD<Municipio, Integer>{
    List<Municipio> getByDepartamentoId(Integer id);

    List<Municipio> getByDepartamentoPaisId(Integer paisId);
}
