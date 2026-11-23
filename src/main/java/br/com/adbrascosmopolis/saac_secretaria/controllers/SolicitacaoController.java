package br.com.adbrascosmopolis.saac_secretaria.controllers;

import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.desligamento.SolicitacaoDesligamentoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.desligamento.SolicitacaoDesligamentoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.mudanca.SolicitacaoMudancaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.mudanca.SolicitacaoMudancaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.reconciliacao.SolicitacaoReconciliacaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.reconciliacao.SolicitacaoReconciliacaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.transferencia.SolicitacaoTransferenciaRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.transferencia.SolicitacaoTransferenciaResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao.SolicitacaoUniaoRequestDTO;
import br.com.adbrascosmopolis.saac_secretaria.dto.solicitacao.uniao.SolicitacaoUniaoResponseDTO;
import br.com.adbrascosmopolis.saac_secretaria.factory.solicitacao.SolicitacaoManagerService;
import br.com.adbrascosmopolis.saac_secretaria.models.*;
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

    //Tranferencia
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
                .body(SolicitacaoTransferenciaResponseDTO.fromSolicitacaoTransferencia(transferencia));
    }

    //Mudanca
    @PostMapping("/mudanca")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_SOLICITACAO_CREATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_SOLICITACAO_CREATE_LOCAL')")
    public ResponseEntity<SolicitacaoMudancaResponseDTO> criarMudanca(
            @Valid @RequestBody SolicitacaoMudancaRequestDTO request) {

        Solicitacao solicitacao = solicitacaoManagerService.criar(request);

        if (!(solicitacao instanceof SolicitacaoMudanca mudanca)) {
            throw new IllegalStateException(
                    "O serviço não retornou uma solicitação de mudança.");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(SolicitacaoMudancaResponseDTO.fromSolicitacaoMudanca(mudanca));
    }

    //União
    @PostMapping("/uniao")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_SOLICITACAO_CREATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_SOLICITACAO_CREATE_LOCAL')")
    public ResponseEntity<SolicitacaoUniaoResponseDTO> criarUniao(
            @Valid @RequestBody SolicitacaoUniaoRequestDTO request) {

        Solicitacao solicitacao = solicitacaoManagerService.criar(request);

        if (!(solicitacao instanceof SolicitacaoUniao uniao)) {
            throw new IllegalStateException(
                    "O serviço não retornou uma solicitação de união.");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(SolicitacaoUniaoResponseDTO.fromSolicitacaoUniao(uniao));
    }

    //Reconciliacao
    @PostMapping("/reconciliacao")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_SOLICITACAO_CREATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_SOLICITACAO_CREATE_LOCAL')")
    public ResponseEntity<SolicitacaoReconciliacaoResponseDTO> criarReconciliacao(
            @Valid @RequestBody SolicitacaoReconciliacaoRequestDTO request) {

        Solicitacao solicitacao = solicitacaoManagerService.criar(request);

        if (!(solicitacao instanceof SolicitacaoReconciliacao reconciliacao)) {
            throw new IllegalStateException(
                    "O serviço não retornou uma solicitação de reconcilicao.");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(SolicitacaoReconciliacaoResponseDTO.fromSolicitacaoReconciliacao(reconciliacao));
    }

    //Desligamento
    @PostMapping("/desligamento")
    @PreAuthorize("hasAuthority('PERMISSION_SECRETARIA_SOLICITACAO_CREATE_GLOBAL') or hasAuthority('PERMISSION_SECRETARIA_SOLICITACAO_CREATE_LOCAL')")
    public ResponseEntity<SolicitacaoDesligamentoResponseDTO> criarDesligmento(
            @Valid @RequestBody SolicitacaoDesligamentoRequestDTO request) {

        Solicitacao solicitacao = solicitacaoManagerService.criar(request);

        if (!(solicitacao instanceof SolicitacaoDesligamento desligamento)) {
            throw new IllegalStateException(
                    "O serviço não retornou uma solicitação de desligamento.");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(SolicitacaoDesligamentoResponseDTO.fromSolicitacaoDesligamento(desligamento));
    }



}