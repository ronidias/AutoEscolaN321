package br.com.senai.autoescolan321.model.dto.usuario;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;


public record DadosAtualizacaoUsuario(

        @NotNull
        @Valid
        Long id,
        String login,
        String senha
        ) {
}