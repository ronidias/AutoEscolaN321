package br.com.senai.autoescolan321.adapters.in.controller.request.instrucao;

import br.com.senai.autoescolan321.application.core.domain.enums.Motivo;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoInstrucao(

        @NotNull
        Long id,

        @NotNull
        Motivo motivo) {
}