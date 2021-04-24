package seminario.serminarioproyecto.service;

import seminario.serminarioproyecto.model.Sucursal;

import java.util.List;

public interface SucursalSrvInt extends ICRUD<Sucursal,Integer>{
    List<Sucursal> getByComercioMunicipio(Integer idComercio, Integer idMuncipio);
    List<Sucursal> getByComercio(Integer idComercio);
}
