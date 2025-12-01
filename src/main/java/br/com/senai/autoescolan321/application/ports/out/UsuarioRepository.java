package br.com.senai.autoescolan321.application.ports.out;

import br.com.senai.autoescolan321.application.core.domain.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);
    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByLogin(String username);
}