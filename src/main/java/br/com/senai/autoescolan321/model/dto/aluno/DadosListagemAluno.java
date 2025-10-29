package br.com.senai.autoescolan321.model.dto.aluno;


import br.com.senai.autoescolan321.entity.Aluno;

public record DadosListagemAluno(


        Long id,
        String nome,
        String email,
        String cpf ){

    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }
}