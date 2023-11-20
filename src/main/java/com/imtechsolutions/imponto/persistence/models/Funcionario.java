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

    @Column(name = "nome_funcionario")
    private String nomeFuncionario;

    @Column(name = "id_empresa")
    private Long idEmpresa;

    @Column(name = "id_historico_marcacao_ponto")
    private Long idHistoricoMarcacaoPonto;

    @Column(name = "id_obra")
    private Long idObra;

    public Funcionario() {
        // Construtor vazio padrão
    }

    public Funcionario(int idFuncionario,String senha, String nomeFuncionario, Long idEmpresa, Long idHistoricoMarcacaoPonto, Long idObra) {
        this.nomeFuncionario = nomeFuncionario;
        this.idEmpresa = idEmpresa;
        this.senha = senha;
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

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdHistoricoMarcacaoPonto() {
        return idHistoricoMarcacaoPonto;
    }

    public void setIdHistoricoMarcacaoPonto(Long idHistoricoMarcacaoPonto) {
        this.idHistoricoMarcacaoPonto = idHistoricoMarcacaoPonto;
    }

    public Long getIdObra() {
        return idObra;
    }

    public void setIdObra(Long idObra) {
        this.idObra = idObra;
    }

}
