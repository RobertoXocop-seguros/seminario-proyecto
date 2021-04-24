package seminario.serminarioproyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminario.serminarioproyecto.model.Pais;
import seminario.serminarioproyecto.repo.PaisRepo;
import seminario.serminarioproyecto.service.PaisSrvInt;

import java.util.List;
import java.util.Optional;

@Service
public class PaisSrvImpl implements PaisSrvInt {

    @Autowired
    private PaisRepo repo;

    @Override
    public Pais registrar(Pais obj) {
        return this.repo.save(obj);
    }

    @Override
    public Pais modificar(Pais obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Pais> listar() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Pais> listarPorId(Integer id) {
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
