package br.com.senai.autoescolan321.adapters.in.controller;

import br.com.senai.autoescolan321.adapters.in.controller.request.usuario.DadosAlteracaoSenha;
import br.com.senai.autoescolan321.adapters.in.controller.request.usuario.DadosCadastroUsuario;
import br.com.senai.autoescolan321.adapters.in.controller.response.usuario.DadosDetalhamentoUsuario;
import br.com.senai.autoescolan321.adapters.in.controller.response.usuario.DadosListagemUsuario;
import br.com.senai.autoescolan321.adapters.in.controller.request.usuario.DadosAtualizacaoPerfil;
import br.com.senai.autoescolan321.application.core.usecases.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(
            UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<DadosDetalhamentoUsuario> cadastrarUsuario(
            @RequestBody @Valid DadosCadastroUsuario dados,
            UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoUsuario dto = usuarioService.cadastrar(dados);
        URI uri = uriBuilder.path("/usuarios/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> listarUsuarios(
            @ParameterObject @PageableDefault(size = 10, sort = {"login"}) Pageable paginacao) {
        return ResponseEntity.ok(usuarioService.listar(paginacao));
    }

    @PatchMapping
    public ResponseEntity<DadosDetalhamentoUsuario> atualizarPerfilUsuario(
            @RequestBody @Valid DadosAtualizacaoPerfil dados) {
        return ResponseEntity.ok(usuarioService.atualizarPerfil(dados));
    }

    @PatchMapping("/senha")
    public ResponseEntity<String> alterarSenhaUsuario(
            @RequestBody @Valid DadosAlteracaoSenha dados) {
        return usuarioService.alterarSenha(dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoUsuario> excluirUsuario(
            @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(usuarioService.excluir(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoUsuario> detalharUsuario(
            @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.detalhar(id));
    }
}