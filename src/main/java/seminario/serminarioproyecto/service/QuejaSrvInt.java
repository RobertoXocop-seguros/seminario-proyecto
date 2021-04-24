package seminario.serminarioproyecto.service;

import seminario.serminarioproyecto.dto.ResultDTO;
import seminario.serminarioproyecto.model.Queja;

import java.util.List;

public interface QuejaSrvInt extends ICRUD<Queja, Integer>{
    List<ResultDTO> quejasPorComercio();
    List<ResultDTO> quejasPorMunicipio();
    List<ResultDTO> quejasPorDepartamento();
    List<ResultDTO> quejasPorRegion();
}
