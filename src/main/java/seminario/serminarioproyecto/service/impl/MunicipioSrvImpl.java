package seminario.serminarioproyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminario.serminarioproyecto.model.Municipio;
import seminario.serminarioproyecto.repo.MunicipioRepo;
import seminario.serminarioproyecto.service.MunicipioSrvInt;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioSrvImpl implements MunicipioSrvInt {

    @Autowired
    private MunicipioRepo repo;

    @Override
    public Municipio registrar(Municipio obj) {
        return this.repo.save(obj);
    }

    @Override
    public Municipio modificar(Municipio obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Municipio> listar() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Municipio> listarPorId(Integer id) {
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

    @Override
    public List<Municipio> getByDepartamentoId(Integer id) {
        return this.repo.getAllByDepartamento_IdOrderByNombre(id);
    }

    @Override
    public List<Municipio> getByDepartamentoPaisId(Integer paisId) {
        return this.repo.getAllByDepartamento_Pais_Id(paisId);
    }
}
