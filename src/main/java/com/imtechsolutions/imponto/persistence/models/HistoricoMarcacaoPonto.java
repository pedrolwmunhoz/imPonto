package com.imtechsolutions.imponto.persistence.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "historico_marcacao_ponto", schema = "impontodb")
@Entity
public class HistoricoMarcacaoPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historico")
    private int idHistorico;

    @Column(name = "id_funcionario")
    private int idFuncionario;

    @Column(name = "tipo_marcacao")
    private int tipoMarcacao;

    @Column(name = "data_completa_inclusao")
    private Date dataCompletaInclusao;

    @Column(name = "ano_inclusao")
    private Date anoInclusao;

    @Column(name = "mes_inclusao")
    private Date mesInclusao;

    @Column(name = "dia_inclusao")
    private Date diaInclusao;

    @Column(name = "hora_inclusao")
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
