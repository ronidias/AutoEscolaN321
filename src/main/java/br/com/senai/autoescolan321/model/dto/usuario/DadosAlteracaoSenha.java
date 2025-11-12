package br.com.senai.autoescolan321.model.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAlteracaoSenha(

        @NotNull
        Long id,

        @NotBlank
        String senhaAtual,

        @NotBlank
        @Pattern(regexp = ".{8}")
        String novaSenha) {
}

