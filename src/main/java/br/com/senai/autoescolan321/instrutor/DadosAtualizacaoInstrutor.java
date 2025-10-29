package br.com.senai.autoescolan321.instrutor;

import br.com.senai.autoescolan321.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


public record DadosAtualizacaoInstrutor(

        @NotNull
        @Valid
        Long id,
        String nome,
        String telefone,
        Especialidade especialidade,
        DadosEndereco endereco) {
}