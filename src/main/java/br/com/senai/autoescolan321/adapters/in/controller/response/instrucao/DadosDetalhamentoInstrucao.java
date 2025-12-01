package br.com.senai.autoescolan321.adapters.in.controller.response.instrucao;

import br.com.senai.autoescolan321.application.core.domain.enums.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalhamentoInstrucao(
        Long id,
        String nomeAluno,
        String nomeInstrutor,
        Especialidade especialidade,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data,
        Boolean cancelada) {
}