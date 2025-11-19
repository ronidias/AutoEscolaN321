package br.com.senai.autoescolan321.adapters.in.controller.response.usuario;

import br.com.senai.autoescolan321.application.core.domain.enums.Perfil;
import br.com.senai.autoescolan321.application.core.domain.model.Usuario;

public record DadosDetalhamentoUsuario(
        Long id,
        String login,
        String senha,
        Perfil perfil) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin(), usuario.getSenha(), usuario.getPerfil());
    }
}