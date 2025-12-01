package br.com.senai.autoescolan321.adapters.in.controller.response.instrutor;

import br.com.senai.autoescolan321.adapters.in.controller.request.endereco.DadosEndereco;
import br.com.senai.autoescolan321.application.core.domain.enums.Especialidade;

public record DadosDetalhamentoInstrutor(
        Long id,
        Boolean ativo,
        String nome,
        String email,
        String telefone,
        String cnh,
        Especialidade especialidade,
        DadosEndereco endereco) {
}
