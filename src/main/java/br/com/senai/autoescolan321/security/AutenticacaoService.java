package br.com.senai.autoescolan321.security;

import br.com.senai.autoescolan321.application.ports.out.UsuarioRepository;
import br.com.senai.autoescolan321.exception.types.usuario.UsuarioInativoException;
import br.com.senai.autoescolan321.exception.types.usuario.UsuarioNaoExisteException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public AutenticacaoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(username).map(usuario -> {
            if(!usuario.isAtivo()) {
                throw new UsuarioInativoException("Usuário inativo ou excluído: " + username + "!");
            }
            return usuario;
        }).orElseThrow(() -> new UsuarioNaoExisteException("Usuário informado não existe!"));
    }
}