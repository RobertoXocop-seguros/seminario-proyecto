package seminario.serminarioproyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminario.serminarioproyecto.model.Comercio;
import seminario.serminarioproyecto.repo.ComercioRepo;
import seminario.serminarioproyecto.service.ComercioSrvInt;

import java.util.List;
import java.util.Optional;

@Service
public class ComercioSrvImpl implements ComercioSrvInt {

    @Autowired
    private ComercioRepo repo;

    @Override
    public Comercio registrar(Comercio obj) {
        return this.repo.save(obj);
    }

    @Override
    public Comercio modificar(Comercio obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Comercio> listar() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Comercio> listarPorId(Integer id) {
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
