package com.imtechsolutions.imponto.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imtechsolutions.imponto.persistence.models.Funcionario;
import com.imtechsolutions.imponto.services.FuncionarioService;

@RestController
@RequestMapping("/cadastro/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/insert")
    public ResponseEntity<?> inserirFuncionario(@RequestBody Funcionario funcionario) {
        try {
            Funcionario novoFuncionario = funcionarioService.inserirFuncionario(funcionario);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> atualizarFuncionario(@RequestBody Funcionario funcionario) {
        try {
            Funcionario atualizadoFuncionario = funcionarioService.atualizarFuncionario(funcionario);
            return ResponseEntity.status(HttpStatus.CREATED).body(atualizadoFuncionario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro na atualização do funcionário.");
        }
    }

    @GetMapping("/get")
    public List<Funcionario> consultarFuncionarios() {
        return funcionarioService.consultarFuncionarios();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> consultarFuncionarioPorId(@PathVariable Long id) {
        int idAsInt = id.intValue();
        Optional<Funcionario> funcionario = funcionarioService.consultarFuncionarioPorId(idAsInt);
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário com ID " + id + " não encontrado.");
        }
    }
}
