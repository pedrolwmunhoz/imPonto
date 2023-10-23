package com.imtechsolutions.imponto.persistence.dao;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import com.imtechsolutions.imponto.persistence.models.Funcionario;

@Repository
public class FuncionarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String inserirFuncionario(Funcionario funcionario) {
        try{
            entityManager.persist(funcionario);
            return "Deu";
        } catch(PersistenceException e) {
            return "erro insercao";
        }
   
    }

    public Funcionario consultarFuncionario(Long id) {
        return entityManager.find(Funcionario.class, id);
    }

    @Transactional
    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        return entityManager.merge(funcionario);
    }
}
