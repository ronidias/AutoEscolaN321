package br.com.senai.autoescolan321.adapters.in.controller.response.aluno;

import br.com.senai.autoescolan321.application.core.domain.model.Aluno;
import br.com.senai.autoescolan321.application.core.domain.vo.Endereco;

public record DadosDetalhamentoAluno(
        Long id,
        Boolean ativo,
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco) {
    public DadosDetalhamentoAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getAtivo(), aluno.getNome(), aluno.getEmail(), aluno.getTelefone(), aluno.getCpf(), aluno.getEndereco());
    }
}