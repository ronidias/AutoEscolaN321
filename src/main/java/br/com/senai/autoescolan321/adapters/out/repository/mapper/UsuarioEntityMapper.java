package br.com.senai.autoescolan321.adapters.out.repository.mapper;

import br.com.senai.autoescolan321.adapters.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescolan321.application.core.domain.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityMapper {
    public Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getLogin(),
                entity.getSenha(),
                entity.getPerfil(),
                entity.getAtivo()
        );
    }

    public UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getSenha(),
                usuario.getPerfil(),
                usuario.getAtivo()
        );
    }
}