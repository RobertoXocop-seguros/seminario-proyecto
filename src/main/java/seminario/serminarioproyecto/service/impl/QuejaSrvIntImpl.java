package seminario.serminarioproyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminario.serminarioproyecto.dto.ResultDTO;
import seminario.serminarioproyecto.model.Queja;
import seminario.serminarioproyecto.repo.QuejaRepo;
import seminario.serminarioproyecto.service.QuejaSrvInt;

import java.util.List;
import java.util.Optional;

@Service
public class QuejaSrvIntImpl implements QuejaSrvInt {

    @Autowired
    private QuejaRepo repo;


    @Override
    public Queja registrar(Queja obj) {
        return this.repo.save(obj);
    }

    @Override
    public Queja modificar(Queja obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Queja> listar() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Queja> listarPorId(Integer id) {
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
    public List<ResultDTO> quejasPorComercio() {
        return this.repo.quejasPorComercio();
    }

    @Override
    public List<ResultDTO> quejasPorMunicipio() {
        return this.repo.quejasPorMunicipio();
    }

    @Override
    public List<ResultDTO> quejasPorDepartamento() {
        return this.repo.quejasPorDepartamento();
    }

    @Override
    public List<ResultDTO> quejasPorRegion() {
        return this.repo.quejasPorRegion();
    }
}
