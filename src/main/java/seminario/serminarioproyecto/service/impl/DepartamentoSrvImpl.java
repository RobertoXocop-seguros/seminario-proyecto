package seminario.serminarioproyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminario.serminarioproyecto.model.Departamento;
import seminario.serminarioproyecto.repo.DepartamentoRepo;
import seminario.serminarioproyecto.service.DepartamentoSrvInt;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoSrvImpl implements DepartamentoSrvInt {

    @Autowired
    private DepartamentoRepo repo;

    @Override
    public Departamento registrar(Departamento obj) {
        return this.repo.save(obj);
    }

    @Override
    public Departamento modificar(Departamento obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Departamento> listar() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Departamento> listarPorId(Integer id) {
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

    public List<Departamento> listarByIdPais(Integer id){
        return this.repo.getDepartamentoByPais(id);
    }
}
