package seminario.serminarioproyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminario.serminarioproyecto.model.Sucursal;
import seminario.serminarioproyecto.repo.SucursalRepo;
import seminario.serminarioproyecto.service.SucursalSrvInt;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalSrvImpl implements SucursalSrvInt {

    @Autowired
    private SucursalRepo repo;

    @Override
    public Sucursal registrar(Sucursal obj) {
        return this.repo.save(obj);
    }

    @Override
    public Sucursal modificar(Sucursal obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Sucursal> listar() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Sucursal> listarPorId(Integer id) {
        return this.repo.findById(id);
    }

    @Override
    public boolean eliminar(Integer id) {
        if (this.repo.findById(id).isPresent()){{
            this.repo.deleteById(id);
            return true;
        }}
        return false;
    }

    @Override
    public List<Sucursal> getByComercioMunicipio(Integer idComercio, Integer idMuncipio) {
        return this.repo.getAllByComercio_IdAndMunicipio_Id(idComercio,idMuncipio);
    }

    @Override
    public List<Sucursal> getByComercio(Integer idComercio) {
        return this.repo.getAllByComercio_Id(idComercio);
    }
}
