package br.com.senai.autoescolan321.adapters.in.controller.response.instrutor;

import br.com.senai.autoescolan321.application.core.domain.enums.Especialidade;

public record DadosListagemInstrutor(
        Long id,
        String nome,
        String email,
        String cnh,
        Especialidade especialidade) {
}