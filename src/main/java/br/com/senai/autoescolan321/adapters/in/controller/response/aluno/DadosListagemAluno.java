package br.com.senai.autoescolan321.adapters.in.controller.response.aluno;

public record DadosListagemAluno(
        Long id,
        String nome,
        String email,
        String cpf) {
}