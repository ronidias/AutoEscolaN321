package br.com.senai.autoescolan321.adapters.in.controller.response.usuario;

import br.com.senai.autoescolan321.application.core.domain.enums.Perfil;

public record DadosDetalhamentoUsuario(
        Long id,
        String login,
        Perfil perfil,
        Boolean ativo) {
}