package com.imtechsolutions.imponto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imtechsolutions.imponto.persistence.models.Funcionario;
import com.imtechsolutions.imponto.persistence.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario inserirFuncionario(Funcionario funcionario) {
        if (repository.existsById(funcionario.getIdFuncionario())) {
            // Lançar uma exceção, retornar null ou tratar de acordo com a sua necessidade
            // Por exemplo:
            throw new IllegalArgumentException("Funcionário com o mesmo CPF já existe.");
        }

        return repository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        if (repository.existsById(funcionario.getIdFuncionario())) {
            return repository.save(funcionario);
        } else {
            // Lançar uma exceção, retornar null ou tratar de acordo com a sua necessidade
            // Por exemplo:
            throw new IllegalArgumentException("Funcionário não encontrado.");
        }
    }
    public Funcionario validarLogin(int idFuncionario, String senha) {
        try {
            Funcionario funcionario = repository.findByIdAndSenha(idFuncionario, senha);
            
            return funcionario;
        } catch (Exception e) {
            // Trate a exceção
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Funcionario> consultarFuncionarios() {
        return repository.findAll();
    }

    public Optional<Funcionario> consultarFuncionarioPorId(int id) {
        return repository.findById(id);
    }
}
