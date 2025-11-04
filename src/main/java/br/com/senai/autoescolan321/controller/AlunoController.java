package br.com.senai.autoescolan321.controller;

import br.com.senai.autoescolan321.model.dto.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescolan321.model.dto.aluno.DadosCadastroAluno;
import br.com.senai.autoescolan321.model.dto.aluno.DadosListagemAluno;
import br.com.senai.autoescolan321.domain.Aluno;
import br.com.senai.autoescolan321.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    @Transactional
    public void cadastrarAluno(@RequestBody @Valid DadosCadastroAluno dados) {
        alunoRepository.save(new Aluno(dados));
    }

    @GetMapping
    public Page<DadosListagemAluno> listarAluno(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return alunoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemAluno::new);
    }

    @PutMapping
    @Transactional
    public void atualizarAluno(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        Aluno aluno = alunoRepository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirAluno(@PathVariable Long id) {
        Aluno aluno = alunoRepository.getReferenceById(id);
        aluno.excluir();
    }
}