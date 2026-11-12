package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.transferencia.SolicitacaoTransferenciaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.transferencia.SolicitacaoTransferenciaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao.SolicitacaoManagerService;
import br.com.adbrascosmopolis.saac_secretaria.models.Solicitacao;
import br.com.adbrascosmopolis.saac_secretaria.models.SolicitacaoTransferencia;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solicitacoes")
public class SolicitacaoController {

    private final SolicitacaoManagerService solicitacaoManagerService;

    public SolicitacaoController(SolicitacaoManagerService solicitacaoManagerService) {
        this.solicitacaoManagerService = solicitacaoManagerService;
    }

    @PostMapping("/transferencia")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_SOLICITACAO_CREATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_SOLICITACAO_CREATE_LOCAL')")
    public ResponseEntity<SolicitacaoTransferenciaResponseDTO> criarTransferencia(
            @Valid @RequestBody SolicitacaoTransferenciaRequestDTO request) {

        Solicitacao solicitacao = solicitacaoManagerService.criar(request);

        if (!(solicitacao instanceof SolicitacaoTransferencia transferencia)) {
            throw new IllegalStateException(
                    "O serviço não retornou uma solicitação de transferência.");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(SolicitacaoTransferenciaResponseDTO.fromSolicitacao(transferencia));
    }
}