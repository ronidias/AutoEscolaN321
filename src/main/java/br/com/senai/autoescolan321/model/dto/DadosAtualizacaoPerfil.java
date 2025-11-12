package br.com.senai.autoescolan321.model.dto;

import br.com.senai.autoescolan321.enumeration.Perfil;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPerfil(

        @NotNull
        Long id,

        @NotNull
        Perfil perfil) {
}