package br.com.senai.autoescolan321.adapters.in.controller;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.autoescolan321.adapters.in.controller.response.instrucao.DadosDetalhamentoCancelamento;
import br.com.senai.autoescolan321.adapters.in.controller.response.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescolan321.application.core.usecases.AgendaDeInstrucoes;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrucoes")
@SecurityRequirement(name = "bearer-key")
public class InstrucaoController {
    private final AgendaDeInstrucoes agenda;

    public InstrucaoController(AgendaDeInstrucoes agenda) {
        this.agenda = agenda;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoInstrucao> agendarInstrucao(
            @RequestBody @Valid DadosAgendamentoInstrucao dados) {
        return ResponseEntity.ok(agenda.agendar(dados));
    }

    @PatchMapping
    public ResponseEntity<DadosDetalhamentoCancelamento> cancelarInstrucao(
            @RequestBody @Valid DadosCancelamentoInstrucao dados) {
        return ResponseEntity.ok(agenda.cancelar(dados));
    }
}