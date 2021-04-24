package seminario.serminarioproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seminario.serminarioproyecto.exception.ModelNotFoundException;
import seminario.serminarioproyecto.model.Region;
import seminario.serminarioproyecto.model.Region;
import seminario.serminarioproyecto.service.impl.RegionSrvImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/regiones")
public class RegionController {

    @Autowired
    private RegionSrvImpl regionSrv;

    @GetMapping("/all")
    public ResponseEntity<List<Region>> getAll(){
        return new ResponseEntity<>(regionSrv.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Region>> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(regionSrv.listarPorId(id), HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Region> add(@RequestBody Region region){
        return new ResponseEntity<>(this.regionSrv.registrar(region),HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Region> edit(@RequestBody Region region){
        return new ResponseEntity<>(this.regionSrv.modificar(region),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        if (!this.regionSrv.eliminar(id)){
            throw new ModelNotFoundException("No se encontro elemento para eliminara con Id "+ id);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
