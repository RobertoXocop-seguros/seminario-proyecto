package seminario.serminarioproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seminario.serminarioproyecto.exception.ModelNotFoundException;
import seminario.serminarioproyecto.model.Comercio;
import seminario.serminarioproyecto.service.impl.ComercioSrvImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comercios")
public class ComercioController {

    @Autowired
    private ComercioSrvImpl comercioSrv;

    @GetMapping("/all")
    public ResponseEntity<List<Comercio>> getAll(){
        return  new ResponseEntity<>(this.comercioSrv.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Comercio>> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(this.comercioSrv.listarPorId(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Comercio> add(@RequestBody Comercio obj){
        return new ResponseEntity<>(this.comercioSrv.registrar(obj),HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Comercio> edit(@RequestBody Comercio obj){
        return new ResponseEntity<>(this.comercioSrv.modificar(obj),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        if (!this.comercioSrv.eliminar(id)){
            throw new ModelNotFoundException("No se encontro elemento para eliminara con Id "+ id);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
