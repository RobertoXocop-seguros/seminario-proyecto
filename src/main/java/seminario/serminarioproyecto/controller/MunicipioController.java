package seminario.serminarioproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seminario.serminarioproyecto.exception.ModelNotFoundException;
import seminario.serminarioproyecto.model.Municipio;
import seminario.serminarioproyecto.service.impl.MunicipioSrvImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    @Autowired
    private MunicipioSrvImpl municipioSrv;

    @GetMapping("/all")
    private ResponseEntity<List<Municipio>> getAll(){
        return new ResponseEntity<>(this.municipioSrv.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Municipio>> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(this.municipioSrv.listarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/byDep/{id}")
    private ResponseEntity<List<Municipio>> getAllByDepartamentoId(@PathVariable("id") Integer id){
        return new ResponseEntity<>(this.municipioSrv.getByDepartamentoId(id), HttpStatus.OK);
    }

    @GetMapping("/byDepPaisId/{id}")
    private ResponseEntity<List<Municipio>> getAllByDepartamentoPaisId(@PathVariable("id") Integer id){
        return new ResponseEntity<>(this.municipioSrv.getByDepartamentoPaisId(id), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Municipio> add(@RequestBody Municipio municipio){
        return new ResponseEntity<>(this.municipioSrv.registrar(municipio),HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Municipio> edit(@RequestBody Municipio municipio){
        return new ResponseEntity<>(this.municipioSrv.modificar(municipio),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        if (!this.municipioSrv.eliminar(id)){
            throw new ModelNotFoundException("No se encontro elemento para eliminara con Id "+ id);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
