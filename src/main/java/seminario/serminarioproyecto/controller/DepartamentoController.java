package seminario.serminarioproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seminario.serminarioproyecto.exception.ModelNotFoundException;
import seminario.serminarioproyecto.model.Departamento;
import seminario.serminarioproyecto.service.impl.DepartamentoSrvImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoSrvImpl departamentoSrv;

    @GetMapping("/all")
    public ResponseEntity<List<Departamento>> getAll(){
        return new ResponseEntity<>(this.departamentoSrv.listar(), HttpStatus.OK);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Departamento>> getAllByIdPais(@PathVariable("id") Integer id){
        return new ResponseEntity<>(this.departamentoSrv.listarByIdPais(id), HttpStatus.OK);
    }

    @GetMapping("/{id}}")
    public ResponseEntity<Optional<Departamento>> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(this.departamentoSrv.listarPorId(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Departamento> add(@RequestBody Departamento departamento){
        return new ResponseEntity<>(this.departamentoSrv.registrar(departamento),HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Departamento> edit(@RequestBody Departamento departamento){
        return new ResponseEntity<>(this.departamentoSrv.modificar(departamento),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        if (!this.departamentoSrv.eliminar(id)){
            throw new ModelNotFoundException("No se encontro elemento para eliminara con Id "+ id);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
