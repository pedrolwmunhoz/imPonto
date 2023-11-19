package com.imtechsolutions.imponto.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.imtechsolutions.imponto.persistence.models.HistoricoMarcacaoPonto;

import java.util.Date;

public interface HistoricoMarcacaoPontoRepository extends JpaRepository<HistoricoMarcacaoPonto, Long> {
    @Query("SELECT h FROM HistoricoMarcacaoPonto h WHERE h.anoInclusao = :ano")
    List<HistoricoMarcacaoPonto> findByAnoInclusao(@Param("ano") Date ano);

    @Query("SELECT h FROM HistoricoMarcacaoPonto h WHERE h.mesInclusao = :mes")
    List<HistoricoMarcacaoPonto> findByMesInclusao(@Param("mes") Date mes);

    @Query("SELECT h FROM HistoricoMarcacaoPonto h WHERE h.diaInclusao = :dia")
    List<HistoricoMarcacaoPonto> findByDiaInclusao(@Param("dia") Date dia);    

    @Query("SELECT h FROM HistoricoMarcacaoPonto h WHERE h.horaInclusao = :hora")
    List<HistoricoMarcacaoPonto> findByHoraInclusao(@Param("hora") Date hora);
}
