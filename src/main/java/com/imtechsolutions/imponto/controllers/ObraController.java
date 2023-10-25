package com.imtechsolutions.imponto.controllers;

import com.imtechsolutions.imponto.persistence.models.Obra;
import com.imtechsolutions.imponto.persistence.requests.ObraRequest;
import com.imtechsolutions.imponto.services.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {

    private final ObraService obraService;

    @Autowired
    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @PostMapping("/inserir")
    public ResponseEntity<?> inserirObra(@RequestBody ObraRequest obraRequest) {
        try {
            return obraService.inserirObra(obraRequest);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/atualizar/{idObra}")
    public ResponseEntity<Obra> atualizarObra(@PathVariable int idObra, @RequestBody ObraRequest obraRequest) {
        Obra obra = obraService.atualizarObra(idObra, obraRequest);
        if (obra != null) {
            return ResponseEntity.ok(obra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<Obra>> consultarObras() {
        List<Obra> obras = obraService.consultarObras();
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/consultar/{idObra}")
    public ResponseEntity<Obra> consultarObraPorId(@PathVariable int idObra) {
        Obra obra = obraService.consultarObraPorId(idObra);
        if (obra != null) {
            return ResponseEntity.ok(obra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
