package com.imtechsolutions.imponto.persistence.requests;

import java.util.Date;

public class PontoRequest {

    private int idFuncionario;
    private String senha;
    private Date dataCompletaInclusao;
    private Date anoInclusao;
    private Date mesInclusao;
    private Date diaInclusao;
    private Date horaInclusao;
    private int latitude;
    private int longitude;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
}
