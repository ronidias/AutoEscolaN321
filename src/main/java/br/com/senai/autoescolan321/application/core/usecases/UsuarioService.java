package br.com.senai.autoescolan321.application.core.usecases;

import br.com.senai.autoescolan321.adapters.in.controller.mapper.UsuarioMapper;
import br.com.senai.autoescolan321.adapters.in.controller.request.usuario.DadosAlteracaoSenha;
import br.com.senai.autoescolan321.adapters.in.controller.request.usuario.DadosAtualizacaoPerfil;
import br.com.senai.autoescolan321.adapters.in.controller.request.usuario.DadosCadastroUsuario;
import br.com.senai.autoescolan321.adapters.in.controller.response.usuario.DadosDetalhamentoUsuario;
import br.com.senai.autoescolan321.adapters.in.controller.response.usuario.DadosListagemUsuario;
import br.com.senai.autoescolan321.application.core.domain.model.Usuario;
import br.com.senai.autoescolan321.application.ports.out.UsuarioRepository;
import br.com.senai.autoescolan321.exception.types.usuario.UsuarioNaoExisteException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    public UsuarioService(
            UsuarioMapper usuarioMapper,
            UsuarioRepository usuarioRepository,
            PasswordEncoder encoder) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
    }

    @Transactional
    public DadosDetalhamentoUsuario cadastrar(DadosCadastroUsuario dados) {
        Usuario usuario = usuarioMapper.toEntity(dados);
        Usuario saved = usuarioRepository.save(usuario);
        return usuarioMapper.toDetailsDTO(saved);
    }

    public Page<DadosListagemUsuario> listar(Pageable paginacao) {
        return usuarioRepository.findAllByAtivoTrue(paginacao)
                .map(usuarioMapper::toListDTO);
    }

    @Transactional
    public DadosDetalhamentoUsuario atualizarPerfil(DadosAtualizacaoPerfil dados) {
        Usuario usuario = usuarioRepository.findById(dados.id())
                .orElseThrow(() -> new UsuarioNaoExisteException("ID do usuário informado não existe!"));
        usuario.setPerfil(dados.perfil());
        Usuario saved = usuarioRepository.save(usuario);
        return usuarioMapper.toDetailsDTO(saved);
    }

    @Transactional
    public ResponseEntity<String> alterarSenha(DadosAlteracaoSenha dados) {
        Usuario usuario = (Usuario) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        if(!encoder.matches(dados.senhaAtual(), usuario.getSenha())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Senha Incorreta!");
        }
        usuario.alterarSenha(encoder.encode(dados.novaSenha()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Senha alterada com sucesso!");
    }

    @Transactional
    public DadosDetalhamentoUsuario excluir(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExisteException("ID do usuario informado não existe!"));
        usuario.setAtivo(false);
        Usuario saved = usuarioRepository.save(usuario);
        return usuarioMapper.toDetailsDTO(saved);
    }

    public DadosDetalhamentoUsuario detalhar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExisteException("ID do usuário informado não existe!"));
        return usuarioMapper.toDetailsDTO(usuario);
    }
}