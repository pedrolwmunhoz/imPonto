package com.imtechsolutions.imponto.persistence.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;


@Table(name = "funcionarios", schema = "impontodb")
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private int idFuncionario;

    @Column(name = "senha")
    private String senha;

    // @Id
    // @Column(name = "cpf_funcionario")
    // private String cpfFuncionario;

    @Column(name = "nomeFuncionario")
    private String nomeFuncionario;

    @Column(name = "id_empresa")
    private int idEmpresa;

    @Column(name = "id_historico_marcacao_ponto")
    private int idHistoricoMarcacaoPonto;

    @Column(name = "id_obra")
    private int idObra;

    public Funcionario() {
        // Construtor vazio padrão
    }

    public Funcionario(int idFuncionario, String nomeFuncionario, int idEmpresa, int idHistoricoMarcacaoPonto, int idObra) {
        this.nomeFuncionario = nomeFuncionario;
        this.idEmpresa = idEmpresa;
        this.idHistoricoMarcacaoPonto = idHistoricoMarcacaoPonto;
        this.idObra = idObra;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    // public String getCpfFuncionario() {
    //     return cpfFuncionario;
    // }
    
    // public void setCpfFuncionario(String cpfFuncionario) {
    //     this.cpfFuncionario = cpfFuncionario;
    // }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdHistoricoMarcacaoPonto() {
        return idHistoricoMarcacaoPonto;
    }

    public void setIdHistoricoMarcacaoPonto(int idHistoricoMarcacaoPonto) {
        this.idHistoricoMarcacaoPonto = idHistoricoMarcacaoPonto;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }
    
    // Outros métodos, se necessário
}
