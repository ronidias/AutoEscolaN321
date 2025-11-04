package br.com.senai.autoescolan321.model.dto.instrutor;

import br.com.senai.autoescolan321.domain.endereco.DadosEndereco;
import br.com.senai.autoescolan321.enumeration.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroInstrutor(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{9,11}")
        String cnh,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}