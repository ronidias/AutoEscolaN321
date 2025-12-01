package br.com.senai.autoescolan321.adapters.in.controller.response.instrucao;

import br.com.senai.autoescolan321.application.core.domain.enums.Motivo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalhamentoCancelamento(
        Long id,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCancelamento,
        Motivo motivo) {
}