package br.com.senai.autoescolan321.aluno;

import br.com.senai.autoescolan321.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


public record DadosAtualizacaoAluno(

        @NotNull
        @Valid
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}