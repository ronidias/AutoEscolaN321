package br.com.senai.autoescolan321.model.dto.aluno;

import br.com.senai.autoescolan321.model.dto.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{9,11}")
        String cpf,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}