package br.com.senai.autoescolan321.adapters.in.controller.request.usuario;

import br.com.senai.autoescolan321.application.core.domain.enums.Perfil;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPerfil(

        @NotNull
        Long id,

        @NotNull
        Perfil perfil) {
}