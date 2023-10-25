package com.imtechsolutions.imponto.services;

import com.imtechsolutions.imponto.persistence.models.Obra;
import com.imtechsolutions.imponto.persistence.repositories.ObraRepository;
import com.imtechsolutions.imponto.persistence.requests.ObraRequest;
import com.imtechsolutions.imponto.persistence.responses.InsercaoObraResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraService {

    private final ObraRepository obraRepositorie;

    @Autowired
    public ObraService(ObraRepository obraRepositorie) {
        this.obraRepositorie = obraRepositorie;
    }

    public ResponseEntity<InsercaoObraResponse> inserirObra(ObraRequest obraRequest) {
        try {
            Obra novaObra = new Obra(obraRequest.getNomeObra(), obraRequest.getLatitude(), obraRequest.getLongitude());
            novaObra = obraRepositorie.save(novaObra);
            int idObra = novaObra.getIdObra();
            InsercaoObraResponse response = new InsercaoObraResponse(idObra, true, "Obra incluída com sucesso");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (DataIntegrityViolationException ex) {
            // Trata a exceção de violação de integridade dos dados
            throw new IllegalArgumentException("Erro ao inserir a obra. Verifique os dados fornecidos.");
        } catch (Exception ex) {
            // Trata outras exceções gerais
            throw new IllegalArgumentException("Ocorreu um erro ao inserir a obra.");
        }
    }
    

    public Obra atualizarObra(int idObra, ObraRequest obraRequest) {
        Optional<Obra> optionalObra = obraRepositorie.findById(idObra);
        if (optionalObra.isPresent()) {
            Obra obra = optionalObra.get();
            obra.setNomeObra(obraRequest.getNomeObra());
            obra.setLatitude(obraRequest.getLatitude());
            obra.setLongitude(obraRequest.getLongitude());
            try {
                // Tente salvar a obra após a atualização
                return obraRepositorie.save(obra);
            } catch (DataIntegrityViolationException ex) {
                // Trate a exceção de violação de integridade dos dados (por exemplo, duplicação de chave primária).
                // Você pode registrar um erro, retornar uma mensagem de erro personalizada ou executar outra ação apropriada.
                // Exemplo: log.error("Erro ao atualizar obra: " + ex.getMessage(), ex);
                throw new IllegalArgumentException("Erro ao atualizar a obra. Verifique os dados fornecidos.");
            } catch (Exception ex) {
                // Trate outras exceções gerais que possam ocorrer durante a atualização.
                // Exemplo: log.error("Erro desconhecido ao atualizar obra: " + ex.getMessage(), ex);
                throw new IllegalArgumentException("Ocorreu um erro ao atualizar a obra.");
            }
        }
        return null; // Retorna null se a obra não for encontrada
    }
    

    public List<Obra> consultarObras() {
        return obraRepositorie.findAll();
    }

    public Obra consultarObraPorId(int idObra) {
        Optional<Obra> optionalObra = obraRepositorie.findById(idObra);
        return optionalObra.orElse(null); // Retorna null se a obra não for encontrada
    }

    public double buscarLatitude(int idObra) {
        Optional<Obra> optionalObra = obraRepositorie.findById(idObra);
        if (optionalObra.isPresent()) {
            Obra obra = optionalObra.get();
            return obra.getLatitude();
        }
        return 0.0; // Pode ajustar o valor padrão de retorno conforme necessário
    }

    public double buscarLongitude(int idObra) {
        Optional<Obra> optionalObra = obraRepositorie.findById(idObra);
        if (optionalObra.isPresent()) {
            Obra obra = optionalObra.get();
            return obra.getLongitude();
        }
        return 0.0; // Pode ajustar o valor padrão de retorno conforme necessário
    }
}
