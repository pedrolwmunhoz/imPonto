package com.imtechsolutions.imponto.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.imtechsolutions.imponto.persistence.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
    @Query("SELECT f FROM Funcionario f WHERE f.idFuncionario = :id AND f.senha = :senha")
    Funcionario findByIdAndSenha(@Param("id") int id, @Param("senha") String senha);
}