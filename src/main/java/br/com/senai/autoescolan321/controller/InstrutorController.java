package br.com.senai.autoescolan321.controller;

import br.com.senai.autoescolan321.instrutor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping
    @Transactional
    public void cadastrarInstrutor(@RequestBody @Valid DadosCadastroInstrutor dados) {
        instrutorRepository.save(new Instrutor(dados));
    }

    @GetMapping
    public Page<DadosListagemInstrutor> listarInstrutores(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return instrutorRepository.findAll(paginacao).map(DadosListagemInstrutor::new);
    }

    @PutMapping
    @Transactional
    public void atualizarInstrutor(@RequestBody @Valid DadosAtualizacaoInstrutor dados) {
        Instrutor instrutor = instrutorRepository.getReferenceById(dados.id());
        instrutor.atualizarInformacoes(dados);
    }
}