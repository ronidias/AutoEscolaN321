package br.com.senai.autoescolan321.application.core.usecases;

import br.com.senai.autoescolan321.adapters.in.controller.mapper.InstrutorMapper;
import br.com.senai.autoescolan321.adapters.in.controller.request.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.autoescolan321.adapters.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescolan321.adapters.in.controller.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescolan321.adapters.in.controller.response.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.InstrutorRepository;
import br.com.senai.autoescolan321.application.core.domain.model.Instrutor;
import br.com.senai.autoescolan321.exception.types.instrutor.InstrutorNaoExisteException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InstrutorService {
    private final InstrutorRepository instrutorRepository;
    private final InstrutorMapper instrutorMapper;

    public InstrutorService(
            InstrutorRepository instrutorRepository,
            InstrutorMapper instrutorMapper) {
        this.instrutorRepository = instrutorRepository;
        this.instrutorMapper = instrutorMapper;
    }

    @Transactional
    public DadosDetalhamentoInstrutor cadastrar(DadosCadastroInstrutor dados) {
        Instrutor instrutor = instrutorMapper.toEntity(dados);
        instrutorRepository.save(instrutor);
        return instrutorMapper.toDetailsDTO(instrutor);
    }

    public Page<DadosListagemInstrutor> listar(Pageable paginacao) {
        return instrutorRepository.findAllByAtivoTrue(paginacao).map(instrutorMapper::toListDTO);
    }

    @Transactional
    public DadosDetalhamentoInstrutor atualizar(DadosAtualizacaoInstrutor dados) {
        Instrutor instrutor = instrutorRepository.findById(dados.id())
                .orElseThrow(() -> new InstrutorNaoExisteException("ID do instrutor informado não existe!"));
        //instrutor.atualizarInformacoes(dados);
        instrutorMapper.updateEntityFromDTO(dados, instrutor);
        instrutorRepository.save(instrutor);
        return instrutorMapper.toDetailsDTO(instrutor);
    }

    @Transactional
    public DadosDetalhamentoInstrutor excluir(Long id) {
        Instrutor instrutor = instrutorRepository.findById(id)
                .orElseThrow(() -> new InstrutorNaoExisteException("ID do instrutor informado não existe!"));
        instrutor.setAtivo(false);
        instrutorRepository.save(instrutor);
        return instrutorMapper.toDetailsDTO(instrutor);
    }

    public DadosDetalhamentoInstrutor detalhar(Long id) {
        Instrutor instrutor = instrutorRepository.findById(id)
                .orElseThrow(() -> new InstrutorNaoExisteException("ID do instrutor infomado não existe!"));
        return instrutorMapper.toDetailsDTO(instrutor);
    }
}