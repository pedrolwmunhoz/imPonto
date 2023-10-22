package com.imtechsolutions.imponto.controller;
import com.imtechsolutions.imponto.persistence.dao.FuncionarioDao;
import com.imtechsolutions.imponto.persistence.models.Funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioDao funcionarioDao;

    @Autowired
    public FuncionarioController(FuncionarioDao funcionarioDao) {
        this.funcionarioDao = funcionarioDao;
    }

    @PostMapping
    public void inserirFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioDao.inserirFuncionario(funcionario);
    }

    @GetMapping("/{id}")
    public Funcionario consultarFuncionario(@PathVariable Long id) {
        return funcionarioDao.consultarFuncionario(id);
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        funcionario.setIdFuncionario(id);
        return funcionarioDao.atualizarFuncionario(funcionario);
    }
}
