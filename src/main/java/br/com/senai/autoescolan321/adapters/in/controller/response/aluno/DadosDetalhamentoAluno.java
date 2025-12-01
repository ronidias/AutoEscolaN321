package br.com.senai.autoescolan321.adapters.in.controller.response.aluno;

import br.com.senai.autoescolan321.adapters.in.controller.request.endereco.DadosEndereco;

public record DadosDetalhamentoAluno(
        Long id,
        Boolean ativo,
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco) {
}