package com.imtechsolutions.imponto.persistence.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "historicoMarcacaodePonto", schema = "impontodb")
@Entity
public class HistoricoMarcacaoPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorico")
    private int idHistorico;

    @Column(name = "idFuncionario")
    private int idFuncionario;

    @Column(name = "tipoMarcacao")
    private int tipoMarcacao;

    @Column(name = "dataCompletaInclusao")
    private Date dataCompletaInclusao;

    @Column(name = "anoInclusao")
    private Date anoInclusao;

    @Column(name = "mesInclusao")
    private Date mesInclusao;

    @Column(name = "diaInclusao")
    private Date diaInclusao;

    @Column(name = "horaInclusao")
    private Date horaInclusao;

    @Column(name = "latitude")
    private int latitude;

    @Column(name = "longitude")
    private int longitude;

    public HistoricoMarcacaoPonto() {
        // Construtor vazio padrão
    }

    public HistoricoMarcacaoPonto(int idHistorico, int idFuncionario, int tipoMarcacao, Date dataCompletaInclusao, Date anoInclusao, Date mesInclusao, Date diaInclusao, Date horaInclusao, int latitude, int longitude) {
        this.idHistorico = idHistorico;
        this.idFuncionario = idFuncionario;
        this.tipoMarcacao = tipoMarcacao;
        this.dataCompletaInclusao = dataCompletaInclusao;
        this.anoInclusao = anoInclusao;
        this.mesInclusao = mesInclusao;
        this.diaInclusao = diaInclusao;
        this.horaInclusao = horaInclusao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getTipoMarcacao() {
        return tipoMarcacao;
    }

    public void setTipoMarcacao(int tipoMarcacao) {
        this.tipoMarcacao = tipoMarcacao;
    }

    public Date getDataCompletaInclusao() {
        return dataCompletaInclusao;
    }

    public void setDataCompletaInclusao(Date dataCompletaInclusao) {
        this.dataCompletaInclusao = dataCompletaInclusao;
    }

    public Date getAnoInclusao() {
        return anoInclusao;
    }

    public void setAnoInclusao(Date anoInclusao) {
        this.anoInclusao = anoInclusao;
    }

    public Date getMesInclusao() {
        return mesInclusao;
    }

    public void setMesInclusao(Date mesInclusao) {
        this.mesInclusao = mesInclusao;
    }

    public Date getDiaInclusao() {
        return diaInclusao;
    }

    public void setDiaInclusao(Date diaInclusao) {
        this.diaInclusao = diaInclusao;
    }

    public Date getHoraInclusao() {
        return horaInclusao;
    }

    public void setHoraInclusao(Date horaInclusao) {
        this.horaInclusao = horaInclusao;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    // Outros métodos, se necessário
}
