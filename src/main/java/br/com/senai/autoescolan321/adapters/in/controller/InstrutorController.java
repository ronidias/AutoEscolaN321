package br.com.senai.autoescolan321.adapters.in.controller;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.autoescolan321.adapters.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescolan321.adapters.in.controller.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescolan321.adapters.in.controller.response.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescolan321.application.core.usecases.InstrutorService;
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
@RequestMapping("/instrutores")
@SecurityRequirement(name = "bearer-key")
public class InstrutorController {
    private final InstrutorService instrutorService;

    public InstrutorController(InstrutorService instrutorService) {
        this.instrutorService = instrutorService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoInstrutor> cadastrarInstrutor(
            @RequestBody @Valid DadosCadastroInstrutor dados,
            UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoInstrutor dto = instrutorService.cadastrar(dados);
        URI uri = uriBuilder.path("/instrutores/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemInstrutor>> listarInstrutores(
            @ParameterObject @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return ResponseEntity.ok(instrutorService.listar(paginacao));
    }

    @PutMapping
    public ResponseEntity<DadosDetalhamentoInstrutor> atualizarInstrutor(
            @RequestBody @Valid DadosAtualizacaoInstrutor dados) {
        return ResponseEntity.ok(instrutorService.atualizar(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoInstrutor> excluirInstrutor(
            @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(instrutorService.excluir(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoInstrutor> detalharInstrutor(
            @PathVariable Long id) {
        return ResponseEntity.ok(instrutorService.detalhar(id));
    }
}