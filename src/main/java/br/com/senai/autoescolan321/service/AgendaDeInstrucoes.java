package br.com.senai.autoescolan321.service;


import br.com.senai.autoescolan321.domain.Aluno;
import br.com.senai.autoescolan321.domain.Instrucao;
import br.com.senai.autoescolan321.domain.Instrutor;
import br.com.senai.autoescolan321.infra.exception.*;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosDetalahamentoInstrucao;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosDetalhamentoCancelamento;
import br.com.senai.autoescolan321.repository.ValidadorAgendamento;
import br.com.senai.autoescolan321.repository.ValidadorCancelamento;
import br.com.senai.autoescolan321.repository.AlunoRepository;
import br.com.senai.autoescolan321.repository.InstrucaoRepository;
import br.com.senai.autoescolan321.repository.InstrutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AgendaDeInstrucoes {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Autowired
    private List<ValidadorAgendamento> validadoresAgendamento;

    @Autowired
    private List<ValidadorCancelamento> validadoresCancelamento;


    @Transactional
    public DadosDetalahamentoInstrucao agendar(DadosAgendamentoInstrucao dados) {

        if (!alunoRepository.existsById(dados.idAluno())) {
            throw new AlunoNaoExisteException("ID informado não existe!");
        }
        if (dados.idInstrutor() != null && !instrutorRepository.existsById(dados.idInstrutor())) {
            throw new InstrutorNaoExisteException("ID informado não existe");
        }
        validadoresAgendamento.forEach(v -> v.validar(dados));

        Aluno aluno = alunoRepository.getReferenceById(dados.idAluno());
        Instrutor instrutor = escolherInstrutor(dados);
        if (instrutor == null) {
            throw new InstrutorIndisponivelException("Nenhum instrutor disponível para a especialidade informada na data escolhida!");
        }

        Instrucao instrucao = new Instrucao(null, aluno, instrutor, dados.data(), false, null, null);
        instrucaoRepository.save(instrucao);
        return new DadosDetalahamentoInstrucao(instrucao);
    }

    private Instrutor escolherInstrutor(DadosAgendamentoInstrucao dados) {
        if (dados.idInstrutor() != null) {
            return instrutorRepository.getReferenceById(dados.idInstrutor());
        }
        if (dados.especialidade() == null) {
            throw new EspecialidadeNaoInformadaException("Especialidade obrigatória, quando o instrutor não for informado!");

        }
        return instrutorRepository.escolherInstrutorDisponivel(dados.especialidade(), dados.data());
    }

    @Transactional
    public DadosDetalhamentoCancelamento cancelar(DadosCancelamentoInstrucao dados) {

        if (!instrucaoRepository.existsById(dados.idInstrucao())) {
            throw new InstrucaoNaoExisteException("ID da instrução informado não existe");
        }
        validadoresCancelamento.forEach(v -> v.validar(dados));

        Instrucao instrucao = instrucaoRepository.getReferenceById(dados.idInstrucao());
        instrucao.cancelarInstrucao(dados.motivo());
        instrucaoRepository.save(instrucao);
        return new DadosDetalhamentoCancelamento(instrucao);


    }



}
