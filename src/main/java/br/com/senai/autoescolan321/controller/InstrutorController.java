package br.com.senai.autoescolan321.controller;

import br.com.senai.autoescolan321.model.dto.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.autoescolan321.model.dto.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescolan321.model.dto.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescolan321.model.dto.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescolan321.entity.Instrutor;
import br.com.senai.autoescolan321.repository.InstrutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity <DadosDetalhamentoInstrutor> cadastrarInstrutor(
            @RequestBody @Valid DadosCadastroInstrutor dados,
            UriComponentsBuilder uriBuilder
    ) {
        Instrutor instrutor = new Instrutor(dados);
        instrutorRepository.save(new Instrutor(dados));
        URI uri = uriBuilder.path("/instrutores/{id}")
                .buildAndExpand(instrutor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoInstrutor(instrutor));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemInstrutor>> listarInstrutores(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page page = instrutorRepository.findAllByAtivoTrue(paginacao).map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity <DadosDetalhamentoInstrutor> atualizarInstrutor(@RequestBody @Valid DadosAtualizacaoInstrutor dados) {
        Instrutor instrutor = instrutorRepository.getReferenceById(dados.id());
        instrutor.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoInstrutor(instrutor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity <Void> excluirInstrutor(@PathVariable Long id) {
        Instrutor instrutor = instrutorRepository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.noContent().build();
    }
}