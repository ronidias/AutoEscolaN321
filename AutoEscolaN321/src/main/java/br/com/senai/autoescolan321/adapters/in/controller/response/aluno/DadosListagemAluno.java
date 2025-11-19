package br.com.senai.autoescolan321.adapters.in.controller.response.aluno;

import br.com.senai.autoescolan321.application.core.domain.model.Aluno;

public record DadosListagemAluno(
        Long id,
        String nome,
        String email,
        String cpf) {
    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getId(),  aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }
}