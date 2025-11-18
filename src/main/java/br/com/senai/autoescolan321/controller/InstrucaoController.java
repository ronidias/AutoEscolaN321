package br.com.senai.autoescolan321.controller;


import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosDetalahamentoInstrucao;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosDetalhamentoCancelamento;
import br.com.senai.autoescolan321.repository.InstrucaoRepository;
import br.com.senai.autoescolan321.service.AgendaDeInstrucoes;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrucoes")
public class InstrucaoController {


    @Autowired
    AgendaDeInstrucoes agenda;
    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @PostMapping
    public ResponseEntity<DadosDetalahamentoInstrucao> agendarInstrucao(@RequestBody @Valid DadosAgendamentoInstrucao dados){
        return ResponseEntity.ok(agenda.agendar(dados));

    }
    @PatchMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCancelamento> cancelarInstrucao(@RequestBody @Valid DadosCancelamentoInstrucao dados) {
         return ResponseEntity.ok(agenda.cancelar(dados));
    }
}
