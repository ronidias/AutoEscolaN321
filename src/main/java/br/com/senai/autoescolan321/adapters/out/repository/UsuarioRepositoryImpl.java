package br.com.senai.autoescolan321.adapters.out.repository;

import br.com.senai.autoescolan321.adapters.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescolan321.adapters.out.repository.mapper.UsuarioEntityMapper;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.UsuarioJpaRepository;
import br.com.senai.autoescolan321.application.core.domain.model.Usuario;
import br.com.senai.autoescolan321.application.ports.out.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final UsuarioEntityMapper usuarioEntityMapper;
    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioRepositoryImpl(
            UsuarioEntityMapper usuarioEntityMapper,
            UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioEntityMapper = usuarioEntityMapper;
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = usuarioEntityMapper.toEntity(usuario);
        UsuarioEntity saved = usuarioJpaRepository.save(entity);
        return usuarioEntityMapper.toDomain(saved);
    }

    @Override
    public Page<Usuario> findAllByAtivoTrue(Pageable paginacao) {
        return usuarioJpaRepository.findAllByAtivoTrue(paginacao)
                .map(usuarioEntityMapper::toDomain);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioJpaRepository.findById(id)
                .map(usuarioEntityMapper::toDomain);
    }

    @Override
    public Optional<Usuario> findByLogin(String login) {
        return usuarioJpaRepository.findByLogin(login)
                .map(usuarioEntityMapper::toDomain);
    }
}