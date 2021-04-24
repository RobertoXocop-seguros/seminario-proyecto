package seminario.serminarioproyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminario.serminarioproyecto.model.Region;
import seminario.serminarioproyecto.repo.RegionRepo;
import seminario.serminarioproyecto.service.RegionSrvInt;

import java.util.List;
import java.util.Optional;

@Service
public class RegionSrvImpl implements RegionSrvInt {

    @Autowired
    private RegionRepo repo;

    @Override
    public Region registrar(Region obj) {
        return this.repo.save(obj);
    }

    @Override
    public Region modificar(Region obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Region> listar() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Region> listarPorId(Integer id) {
        return this.repo.findById(id);
    }

    @Override
    public boolean eliminar(Integer id) {
        if (this.repo.findById(id).isPresent()){
            this.repo.deleteById(id);
            return true;
        }
        return false;
    }
}
