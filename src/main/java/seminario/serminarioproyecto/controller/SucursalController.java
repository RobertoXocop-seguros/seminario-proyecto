package seminario.serminarioproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seminario.serminarioproyecto.exception.ModelNotFoundException;
import seminario.serminarioproyecto.model.Sucursal;
import seminario.serminarioproyecto.service.impl.SucursalSrvImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalSrvImpl sucursalSrv;

    @GetMapping("/all")
    public ResponseEntity<List<Sucursal>> getAll(){
        return new ResponseEntity<>(sucursalSrv.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Sucursal>> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(sucursalSrv.listarPorId(id), HttpStatus.OK);
    }
    
    @GetMapping("/{idComercio}/{idMunicipio}")
    public ResponseEntity<List<Sucursal>> getByComercioMunicipio(
            @PathVariable("idComercio") Integer idComercio,
            @PathVariable("idMunicipio") Integer idMunicipio
    ){
        return new ResponseEntity<>(sucursalSrv.getByComercioMunicipio(idComercio,idMunicipio),HttpStatus.OK);
    }

    @GetMapping("/byComercio/{idComercio}")
    public ResponseEntity<List<Sucursal>> getByComercio(
            @PathVariable("idComercio") Integer idComercio
    ){
        return new ResponseEntity<>(sucursalSrv.getByComercio(idComercio),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Sucursal> add(@RequestBody Sucursal sucursal){
        return new ResponseEntity<>(this.sucursalSrv.registrar(sucursal),HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Sucursal> edit(@RequestBody Sucursal sucursal){
        return new ResponseEntity<>(this.sucursalSrv.modificar(sucursal),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        if (!this.sucursalSrv.eliminar(id)){
            throw new ModelNotFoundException("No se encontro elemento para eliminara con Id "+ id);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
