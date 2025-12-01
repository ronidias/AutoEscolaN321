package br.com.senai.autoescolan321.adapters.in.controller;

import br.com.senai.autoescolan321.adapters.in.controller.request.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescolan321.adapters.in.controller.request.aluno.DadosCadastroAluno;
import br.com.senai.autoescolan321.adapters.in.controller.response.aluno.DadosDetalhamentoAluno;
import br.com.senai.autoescolan321.adapters.in.controller.response.aluno.DadosListagemAluno;
import br.com.senai.autoescolan321.application.core.usecases.AlunoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/alunos")
@SecurityRequirement(name = "bearer-key")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoAluno> cadastrarAluno(
            @RequestBody @Valid DadosCadastroAluno dados,
            UriComponentsBuilder uriBuilder
    ) {
        DadosDetalhamentoAluno dto = alunoService.cadastrar(dados);
        URI uri = uriBuilder.path("/alunos/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAluno>> listarAlunos(
            @ParameterObject @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao
    ) {
        return ResponseEntity.ok(alunoService.listar(paginacao));
    }

    @PutMapping
    public ResponseEntity<DadosDetalhamentoAluno> atualizarAluno(
            @RequestBody @Valid DadosAtualizacaoAluno dados) {
        return ResponseEntity.ok(alunoService.atualizar(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoAluno> excluirAluno(
            @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(alunoService.excluir(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoAluno> detalharAluno(
            @PathVariable Long id) {
        return ResponseEntity.ok(alunoService.detalhar(id));
    }
}