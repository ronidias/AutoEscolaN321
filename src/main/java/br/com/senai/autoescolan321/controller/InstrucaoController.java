package br.com.senai.autoescolan321.controller;


import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosDetalahamentoInstrucao;
import br.com.senai.autoescolan321.service.AgendaDeInstrucoes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrucoes")
public class InstrucaoController {


    @Autowired
    AgendaDeInstrucoes agenda;

    @PostMapping
    public ResponseEntity<DadosDetalahamentoInstrucao> agendarInstrucao(@RequestBody @Valid DadosAgendamentoInstrucao dados){
        return ResponseEntity.ok(agenda.agendar(dados));

    }
}
