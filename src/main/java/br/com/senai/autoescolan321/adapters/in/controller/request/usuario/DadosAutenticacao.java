package br.com.senai.autoescolan321.adapters.in.controller.request.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosAutenticacao(

        @NotBlank
        String login,

        @NotBlank
        @Pattern(regexp = ".{8}")
        String senha) {
}
