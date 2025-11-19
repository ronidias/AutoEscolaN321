package br.com.senai.autoescolan321.adapters.in.controller;

import br.com.senai.autoescolan321.adapters.in.controller.request.usuario.DadosAlteracaoSenha;
import br.com.senai.autoescolan321.adapters.in.controller.request.usuario.DadosCadastroUsuario;
import br.com.senai.autoescolan321.adapters.in.controller.response.usuario.DadosDetalhamentoUsuario;
import br.com.senai.autoescolan321.adapters.in.controller.response.usuario.DadosListagemUsuario;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.UsuarioRepository;
import br.com.senai.autoescolan321.application.core.domain.model.Usuario;
import br.com.senai.autoescolan321.adapters.in.controller.request.usuario.DadosAtualizacaoPerfil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    public UsuarioController(
            UsuarioRepository usuarioRepository,
            PasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
    }

    @PostMapping
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<DadosDetalhamentoUsuario> cadastrarUsuario(
            @RequestBody @Valid DadosCadastroUsuario dados,
            UriComponentsBuilder uriBuilder
    ) {
        String hashSenha = encoder.encode(dados.senha());
        Usuario usuario = new Usuario(null, dados.login(), hashSenha, dados.perfil(), true);
        usuarioRepository.save(usuario);
        URI uri = uriBuilder.path("/usuarios/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();
        DadosDetalhamentoUsuario dto = new DadosDetalhamentoUsuario(usuario);
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> listarUsuarios(
            @PageableDefault(size = 10, sort = {"login"}) Pageable paginacao
    ) {
        Page page = usuarioRepository.findAllByAtivoTrue(paginacao).map(DadosListagemUsuario::new);
        return ResponseEntity.ok(page);
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoUsuario> atualizarPerfilUsuario(
            @RequestBody @Valid DadosAtualizacaoPerfil dados
    ) {
        Usuario usuario = usuarioRepository.getReferenceById(dados.id());
        usuario.atualizarPerfil(dados.perfil());
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    @PatchMapping("/senha")
    @Transactional
    public ResponseEntity<String> alterarSenhaUsuario(@RequestBody @Valid DadosAlteracaoSenha dados) {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!encoder.matches(dados.senhaAtual(), usuario.getSenha())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Senha Incorreta!");
        }
        usuario.alterarSenha(encoder.encode(dados.novaSenha()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Senha alterada com sucesso!");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.excluir();
        usuarioRepository.save(usuario);
        return ResponseEntity.noContent().build();
    }
}