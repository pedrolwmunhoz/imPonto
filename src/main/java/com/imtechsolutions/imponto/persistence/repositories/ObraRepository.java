package com.imtechsolutions.imponto.persistence.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.imtechsolutions.imponto.persistence.models.HistoricoMarcacaoPonto;
import com.imtechsolutions.imponto.persistence.models.Obra;


public interface ObraRepository extends JpaRepository<Obra, Integer>{
    @Query("SELECT h FROM HistoricoMarcacaoPonto h WHERE h.anoInclusao = :ano")
    List<HistoricoMarcacaoPonto> findByAno(@Param("ano") Date ano);

    @Query("SELECT h FROM HistoricoMarcacaoPonto h WHERE h.mesInclusao = :mes")
    List<HistoricoMarcacaoPonto> findByMes(@Param("mes") Date mes);

    @Query("SELECT h FROM HistoricoMarcacaoPonto h WHERE h.diaInclusao = :dia")
    List<HistoricoMarcacaoPonto> findByDia(@Param("dia") Date dia);

    @Query("SELECT h FROM HistoricoMarcacaoPonto h WHERE h.horaInclusao = :hora")
    List<HistoricoMarcacaoPonto> findByHora(@Param("hora") Date hora);
}