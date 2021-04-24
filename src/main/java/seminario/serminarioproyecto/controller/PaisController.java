package seminario.serminarioproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seminario.serminarioproyecto.exception.ModelNotFoundException;
import seminario.serminarioproyecto.model.Pais;
import seminario.serminarioproyecto.service.impl.PaisSrvImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisSrvImpl paisSrv;

    @GetMapping("/all")
    public ResponseEntity<List<Pais>> getAll(){
        return new ResponseEntity<>(paisSrv.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pais>> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(paisSrv.listarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pais> add(@RequestBody Pais pais){
        return new ResponseEntity<>(this.paisSrv.registrar(pais),HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Pais> edit(@RequestBody Pais pais){
        return new ResponseEntity<>(this.paisSrv.modificar(pais),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        if (!this.paisSrv.eliminar(id)){
            throw new ModelNotFoundException("No se encontro elemento para eliminara con Id "+ id);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
