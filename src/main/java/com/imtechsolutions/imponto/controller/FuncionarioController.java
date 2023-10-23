package com.imtechsolutions.imponto.controller;

import com.imtechsolutions.imponto.persistence.models.Funcionario;
import com.imtechsolutions.imponto.persistence.models.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository repository;


    @PostMapping("/in")
    public ResponseEntity<String> inserirFuncionario(@RequestBody Funcionario funcionario) {
        try {
            // Verifique se o funcionário já existe no repositório
            if (repository.existsById(funcionario.getIdFuncionario())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Funcionário com o mesmo ID já existe.");
            }
            // Realize a lógica de persistência para inserir o funcionário no repositório
            repository.save(funcionario);
    
            // Retorne uma resposta 201 (Created) com uma mensagem de sucesso
            return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário inserido com sucesso.");
        } catch (Exception e) {
            // Em caso de erro na inserção, retorne uma resposta de erro
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro na inserção do funcionário: "+ e);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<String> atualizarFuncionario(@RequestBody Funcionario funcionario) {
        try {
            // Verifique se o funcionário com o ID especificado existe
            Optional<Funcionario> funcionarioExistente = repository.findById(funcionario.getIdFuncionario());
    
            if (funcionarioExistente.isPresent()) {
                // Realize a lógica de persistência para atualizar o funcionário
                repository.save(funcionario);
    
                return ResponseEntity.ok("Funcionário atualizado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro na atualização do funcionário.");
        }
    }
    
    @GetMapping("/get")
    public List<Funcionario> consultarFuncionarios(){
       return repository.findAll(); 
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> consultarFuncionarioPorId(@PathVariable Long id) {
        Optional<Funcionario> funcionario = repository.findById(id);
    
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário com ID " + id + " não encontrado.");
        }
    }    
    
}
