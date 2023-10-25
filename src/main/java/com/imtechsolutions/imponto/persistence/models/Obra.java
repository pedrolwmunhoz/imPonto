package com.imtechsolutions.imponto.persistence.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "obras", schema = "impontodb")
@Entity
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_obra")
    private int idObra;

    @Column(name = "nome_obra")
    private String nomeObra;

    @Column(name = "latitude")
    private int latitude;

    @Column(name = "intitude")
    private int intitude;

    public Obra() {
        // Construtor vazio padrão
    }

    public Obra(String nomeObra, int latitude, int intitude) {
        this.nomeObra = nomeObra;
        this.latitude = latitude;
        this.intitude = intitude;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getNomeObra() {
        return nomeObra;
    }

    public void setNomeObra(String nomeObra) {
        this.nomeObra = nomeObra;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return intitude;
    }

    public void setLongitude(int intitude) {
        this.intitude = intitude;
    }
}
