package br.com.senai.autoescolan321.adapters.in.controller.response.usuario;

import br.com.senai.autoescolan321.application.core.domain.enums.Perfil;
import br.com.senai.autoescolan321.application.core.domain.model.Usuario;

public record DadosListagemUsuario(
        Long id,
        String login,
        Perfil perfil) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin(), usuario.getPerfil());
    }
}