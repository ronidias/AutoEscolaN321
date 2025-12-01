package br.com.senai.autoescolan321.adapters.in.controller.mapper;

import br.com.senai.autoescolan321.adapters.in.controller.request.usuario.DadosCadastroUsuario;
import br.com.senai.autoescolan321.adapters.in.controller.response.usuario.DadosDetalhamentoUsuario;
import br.com.senai.autoescolan321.adapters.in.controller.response.usuario.DadosListagemUsuario;
import br.com.senai.autoescolan321.application.core.domain.model.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    private final PasswordEncoder encoder;

    public UsuarioMapper(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public Usuario toEntity(DadosCadastroUsuario dados) {
        return new Usuario(
                null,
                dados.login(),
                encoder.encode(dados.senha()),
                dados.perfil(),
                true
        );
    }

    public DadosDetalhamentoUsuario toDetailsDTO(Usuario usuario) {
        return new DadosDetalhamentoUsuario(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getPerfil(),
                usuario.getAtivo()
        );
    }

    public DadosListagemUsuario toListDTO(Usuario usuario) {
        return new DadosListagemUsuario(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getPerfil()
        );
    }
}