package com.imtechsolutions.imponto.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.imtechsolutions.imponto.persistence.models.Funcionario;
import com.imtechsolutions.imponto.persistence.models.HistoricoMarcacaoPonto;
import com.imtechsolutions.imponto.persistence.requests.PontoRequest;
import com.imtechsolutions.imponto.persistence.repositories.HistoricoMarcacaoPontoRepository;

@Service
public class HistoricoMarcacaoPontoService {

    private final ObraService obraService;
    private final FuncionarioService funcionarioService;
    private final HistoricoMarcacaoPontoRepository historicoMarcacaoPontoRepository;

    @Autowired
    public HistoricoMarcacaoPontoService(ObraService obraService, FuncionarioService funcionarioService, HistoricoMarcacaoPontoRepository historicoMarcacaoPontoRepository) {
        this.obraService = obraService;
        this.funcionarioService = funcionarioService;
        this.historicoMarcacaoPontoRepository = historicoMarcacaoPontoRepository;
    }

    public ResponseEntity<String> registrarPonto(PontoRequest pontoRequest) {
        boolean registroValido = validarRegistro(pontoRequest);
        if (registroValido) {
            ResponseEntity<?> insercaoResultado = inserirMarcacao(pontoRequest);
            return ResponseEntity.ok(insercaoResultado.getBody().toString());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registro inválido.");
        }
    }

    public boolean validarRegistro(PontoRequest pontoRequest){
        Funcionario funcionario = funcionarioService.validarLogin(pontoRequest.getIdFuncionario(), pontoRequest.getSenha());
        if (funcionario != null) {
            // Chame o serviço da obra para buscar a latitude e longitude
            double latitudeObra = obraService.buscarLatitude(funcionario.getIdObra().intValue());
            double longitudeObra = obraService.buscarLongitude(funcionario.getIdObra().intValue());
    
            // Verifique se a latitude e longitude correspondem à obra
            if (latitudeObra == pontoRequest.getLatitude() && longitudeObra == pontoRequest.getLongitude()) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

    public ResponseEntity<?> inserirMarcacao(PontoRequest pontoRequest) {
        try {
            // Crie uma nova instância de HistoricoMarcacaoPonto
            HistoricoMarcacaoPonto historicoMarcacaoPonto = setarMarcacao(pontoRequest);
    
            // Persiste a instância no banco de dados
            historicoMarcacaoPontoRepository.save(historicoMarcacaoPonto);
    
            return ResponseEntity.ok("Marcação de ponto inserida com sucesso.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao inserir a marcação de ponto.");
        }
    }

    public HistoricoMarcacaoPonto setarMarcacao(PontoRequest pontoRequest){
        //gera o tipo de marcacao - 0 entrada 
        final int tipoMarcacao = gerarTipoMarcacao(pontoRequest.getDiaInclusao());    

       // Crie uma nova instância de HistoricoMarcacaoPonto
       HistoricoMarcacaoPonto historicoMarcacaoPonto = new HistoricoMarcacaoPonto();
    
       // Preencha os campos da instância com os dados de pontoRequest
       historicoMarcacaoPonto.setIdFuncionario(pontoRequest.getIdFuncionario());

       historicoMarcacaoPonto.setTipoMarcacao(tipoMarcacao);
       historicoMarcacaoPonto.setDataCompletaInclusao(pontoRequest.getDataCompletaInclusao());
       historicoMarcacaoPonto.setAnoInclusao(pontoRequest.getAnoInclusao());
       historicoMarcacaoPonto.setMesInclusao(pontoRequest.getMesInclusao());
       historicoMarcacaoPonto.setDiaInclusao(pontoRequest.getDiaInclusao());
       historicoMarcacaoPonto.setHoraInclusao(pontoRequest.getHoraInclusao());
       historicoMarcacaoPonto.setLatitude(pontoRequest.getLatitude());
       historicoMarcacaoPonto.setLongitude(pontoRequest.getLongitude());  
       
       return historicoMarcacaoPonto;
    }

    public int gerarTipoMarcacao(Date dia) {
        // Primeiro, obtenha a lista de registros do dia
        List<HistoricoMarcacaoPonto> historicoPorDia = historicoMarcacaoPontoRepository.findByDiaInclusao(dia);

        // Verifique se a lista está vazia
        if (historicoPorDia.isEmpty()) {
            // Se estiver vazia, defina o tipo como 1 (positivo)
            return 1;
        } else {
            // Se a lista não estiver vazia, obtenha o último registro
            HistoricoMarcacaoPonto ultimoRegistro = historicoPorDia.get(historicoPorDia.size() - 1);

            // Verifique o tipo de marcação no último registro
            if (ultimoRegistro.getTipoMarcacao() % 2 == 0) {
                // Se for 0, defina o tipo como 1 (positivo)
                return 1;
            } else {
                // Se for ouver qualqur outro valor de sobra, defina o tipo como 2 (negativo)
                return 2;
            }
        }
    }
    
    public ResponseEntity<List<HistoricoMarcacaoPonto>> buscarPorAno(Date data) {
        try {
            List<HistoricoMarcacaoPonto> historicoPorAno = historicoMarcacaoPontoRepository.findByAnoInclusao(data);
            return ResponseEntity.ok(historicoPorAno);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<List<HistoricoMarcacaoPonto>> buscarPorMes(Date data) {
        try {
            List<HistoricoMarcacaoPonto> historicoPorMes = historicoMarcacaoPontoRepository.findByMesInclusao(data);
            return ResponseEntity.ok(historicoPorMes);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<List<HistoricoMarcacaoPonto>> buscarPorDia(Date data) {
        try {
            List<HistoricoMarcacaoPonto> historicoPorDia = historicoMarcacaoPontoRepository.findByDiaInclusao(data);
            return ResponseEntity.ok(historicoPorDia);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<List<HistoricoMarcacaoPonto>> buscarPorHora(Date data) {
        try {
            List<HistoricoMarcacaoPonto> historicoPorHora = historicoMarcacaoPontoRepository.findByHoraInclusao(data);
            return ResponseEntity.ok(historicoPorHora);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
}
