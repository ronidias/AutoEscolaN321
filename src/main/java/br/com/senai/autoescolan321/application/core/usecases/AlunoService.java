package br.com.senai.autoescolan321.application.core.usecases;

import br.com.senai.autoescolan321.adapters.in.controller.mapper.AlunoMapper;
import br.com.senai.autoescolan321.adapters.in.controller.request.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescolan321.adapters.in.controller.request.aluno.DadosCadastroAluno;
import br.com.senai.autoescolan321.adapters.in.controller.response.aluno.DadosDetalhamentoAluno;
import br.com.senai.autoescolan321.adapters.in.controller.response.aluno.DadosListagemAluno;
import br.com.senai.autoescolan321.application.core.domain.model.Aluno;
import br.com.senai.autoescolan321.application.ports.out.AlunoRepository;
import br.com.senai.autoescolan321.exception.types.aluno.AlunoNaoExisteException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoService(
            AlunoRepository alunoRepository,
            AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    @Transactional
    public DadosDetalhamentoAluno cadastrar(DadosCadastroAluno dados) {
        Aluno aluno = alunoMapper.toEntity(dados);
        Aluno saved = alunoRepository.save(aluno);
        return alunoMapper.toDetailsDTO(saved);
    }

    public Page<DadosListagemAluno> listar(Pageable paginacao) {
        return alunoRepository.findAllByAtivoTrue(paginacao)
                .map(alunoMapper::toListDTO);
    }

    @Transactional
    public DadosDetalhamentoAluno atualizar(DadosAtualizacaoAluno dados) {
        Aluno aluno = alunoRepository.findById(dados.id())
                .orElseThrow(() -> new AlunoNaoExisteException("ID do aluno informado não existe!"));
        alunoMapper.updateEntityFromDTO(dados, aluno);
        Aluno saved = alunoRepository.save(aluno);
        return alunoMapper.toDetailsDTO(saved);
    }

    @Transactional
    public DadosDetalhamentoAluno excluir(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNaoExisteException("ID do aluno informado não existe!"));
        aluno.setAtivo(false);
        Aluno saved = alunoRepository.save(aluno);
        return alunoMapper.toDetailsDTO(saved);
    }

    public DadosDetalhamentoAluno detalhar(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNaoExisteException("ID do aluno informado não existe!"));
        return alunoMapper.toDetailsDTO(aluno);
    }
}