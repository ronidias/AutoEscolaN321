package br.com.senai.autoescolan321.adapters.in.controller.request.usuario;

import br.com.senai.autoescolan321.application.core.domain.enums.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuario(

        @NotBlank
        @Email
        String login,

        @NotBlank
        @Pattern(regexp = ".{8}")
        String senha,

        @NotNull
        Perfil perfil) {
}