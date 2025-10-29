package br.com.senai.autoescolan321.model.dto.instrutor;

import br.com.senai.autoescolan321.model.dto.endereco.DadosEndereco;
import br.com.senai.autoescolan321.enumeration.Especialidade;
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