package seminario.serminarioproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seminario.serminarioproyecto.dto.ResultDTO;
import seminario.serminarioproyecto.model.Queja;
import seminario.serminarioproyecto.service.QuejaSrvInt;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quejas")
public class QuejaController {

    @Autowired
    private QuejaSrvInt quejaSvr;

    @PostMapping("/add")
    public ResponseEntity<Queja> add(@RequestBody Queja queja){
        return new ResponseEntity<>(this.quejaSvr.registrar(queja), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Queja>> getAll(){
        return  new ResponseEntity<>(this.quejaSvr.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Queja>> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(this.quejaSvr.listarPorId(id),HttpStatus.OK);
    }

    @GetMapping("/porComercio")
    public ResponseEntity<List<ResultDTO>> quejasPorComercio(){
        return new ResponseEntity<>(this.quejaSvr.quejasPorComercio(),HttpStatus.OK);
    }

    @GetMapping("/porMunicipio")
    public ResponseEntity<List<ResultDTO>> quejasPorMunicipio(){
        return new ResponseEntity<>(this.quejaSvr.quejasPorMunicipio(),HttpStatus.OK);
    }

    @GetMapping("/porDepartamento")
    public ResponseEntity<List<ResultDTO>> quejasPorDepartamento(){
        return new ResponseEntity<>(this.quejaSvr.quejasPorDepartamento(),HttpStatus.OK);
    }

    @GetMapping("/porRegion")
    public ResponseEntity<List<ResultDTO>> quejasPorRegion(){
        return new ResponseEntity<>(this.quejaSvr.quejasPorRegion(),HttpStatus.OK);
    }
}
