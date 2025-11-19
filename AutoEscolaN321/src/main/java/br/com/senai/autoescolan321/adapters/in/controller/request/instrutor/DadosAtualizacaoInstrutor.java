package br.com.senai.autoescolan321.adapters.in.controller.request.instrutor;

import br.com.senai.autoescolan321.adapters.in.controller.request.endereco.DadosEndereco;
import br.com.senai.autoescolan321.application.core.domain.enums.Especialidade;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoInstrutor(

        @NotNull
        Long id,
        String nome,
        String telefone,
        Especialidade especialidade,
        DadosEndereco endereco) {
}