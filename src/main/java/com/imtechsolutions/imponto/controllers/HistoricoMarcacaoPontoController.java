package com.imtechsolutions.imponto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imtechsolutions.imponto.persistence.requests.PontoRequest;
import com.imtechsolutions.imponto.services.HistoricoMarcacaoPontoService;

@RestController
@RequestMapping("/ponto")
public class HistoricoMarcacaoPontoController {

    private final HistoricoMarcacaoPontoService historicoMarcacaoPontoService;

    @Autowired
    public HistoricoMarcacaoPontoController(HistoricoMarcacaoPontoService historicoMarcacaoPontoService) {
        this.historicoMarcacaoPontoService = historicoMarcacaoPontoService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarPonto(@RequestBody PontoRequest pontoRequest) {
        return historicoMarcacaoPontoService.registrarPonto(pontoRequest);
    }
}
